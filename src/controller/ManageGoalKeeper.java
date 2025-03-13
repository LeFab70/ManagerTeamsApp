/**
 * @author Fabrice
 * @version 1.0
 * @retun 0
 */
package controller;

import entities.Goalkeeper;
import entities.Player;
import entities.Teams;
import exceptions.PlayerAlreadySavedException;
import exceptions.PlayerNotFoundException;
import exceptions.TeamBudgetMaxException;
import exceptions.TeamsFullException;

import java.util.ArrayList;
import java.util.List;

public class ManageGoalKeeper {
    private static  final int MAX_GOALKEEPERS =25;
    private static List<Goalkeeper> goalkeeperList =new ArrayList<Goalkeeper>();

    //Ajouter un nouveau joueur dans la liste avec des contraintes définies
    public void addPlayer(Goalkeeper player, Teams teamsDestination) throws TeamsFullException, PlayerAlreadySavedException, TeamBudgetMaxException {
        if (player ==null)
            throw new IllegalArgumentException("Le joueur n'est pas définir");
        //liste des joueurs de l'équipe de destination
        goalkeeperList=teamsDestination.getGoalkeepers();
        if (goalkeeperList.size()>= MAX_GOALKEEPERS)
            throw new TeamsFullException("Liste des gardiens l'équipe pleine");
        if(goalkeeperList.contains(player))
            throw new PlayerAlreadySavedException("Gardien déjà dans la liste");

        //tester le budget du club par rapport au salaire du joueur
        double budgetActuel=teamsDestination.getBudgetMax();
        double salaryNewPlayer= player.getSalary();
        if (salaryNewPlayer>=budgetActuel)
            throw new TeamBudgetMaxException("Le budget ne peut pas supporter cet achat, désolé pour "+ player.getName());

        //Si tout est ok==pas d'exceptions alors
        goalkeeperList.add(player);
        // ajouter le joueur et mettre à jour le budget de l'équipe
        teamsDestination.setBudgetMax(teamsDestination.getBudgetMax()-player.getSalary());
        System.out.println("le gardien "+player.getName()+"a été ajouté avec succès");
    }


    //Retrait d'un joueur dans la liste
    public void removePlayer(Goalkeeper player, Teams teamsSource) throws PlayerNotFoundException {
        if (player ==null)
            throw new IllegalArgumentException("Le gardien n'est pas définir");
        //liste des joueurs de l'équipe de destination
        goalkeeperList=teamsSource.getGoalkeepers();
        if(!goalkeeperList.contains(player))
            throw new PlayerNotFoundException("gardien non présent dans la liste de l'équipe");

        // retirer le joueur et mettre à jour le budget de l'équipe
        teamsSource.setBudgetMax(teamsSource.getBudgetMax()+ player.getSalary());
        goalkeeperList.remove(player);
        System.out.println("le gardien "+player.getName()+"a été supprimé avec succès");
    }

    //Transfert d'un joueur d'une équipe à une autre
    public void transferPlayer(Goalkeeper player, Teams teamsSource,Teams teamsDestination, double amountTransfer) throws PlayerNotFoundException, TeamBudgetMaxException, TeamsFullException, PlayerAlreadySavedException {

        //Tester le budget du club destination
        double budgetActuel=teamsDestination.getBudgetMax();
        double salaryNewPlayer= player.getSalary();
        if(salaryNewPlayer+amountTransfer>budgetActuel)
            throw new TeamBudgetMaxException("Le budget du club est insuffisant pour le transfert de "+player.getName());

        // retirer le joueur de son équipe
        removePlayer(player, teamsSource);
        //ajouter le joueur dans la nouvelle équipe
        addPlayer(player, teamsDestination);
        
        // transférer le joueur et mettre à jour le budget de l'équipe
        teamsDestination.setBudgetMax(teamsDestination.getBudgetMax()-amountTransfer);
        System.out.println("le gardien "+player.getName()+"a été transféré de" + teamsSource.getName()+" avec succès vers "+teamsDestination.getName());
        //Todo: comment régler le soucis de annulation de transfert si on a déjà retirer le joueur est qu'il ya une erreur dans l'ajout?? Rollback??
    }

}
