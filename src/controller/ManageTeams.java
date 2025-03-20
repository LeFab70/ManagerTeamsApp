/**
 * La classe ManageTeams permet de gérer les équipes de football,
 * en ajoutant, retirant ou transférant des joueurs, coachs et gardiens.
 * Elle inclut également une gestion du budget des équipes.
 *
 * <p>Fonctionnalités principales :</p>
 * <ul>
 *     <li>Ajouter des joueurs, coachs et gardiens avec vérification des limites.</li>
 *     <li>Retirer un joueur, un coach ou un gardien d'une équipe.</li>
 *     <li>Transférer un joueur d'une équipe à une autre avec contrôle de budget.</li>
 *     <li>Supprimer une équipe de la liste globale des équipes.</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */

package controller;

import entities.*;
import exceptions.*;
import testGlobale.TestingTeams;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ManageTeams {
    private static final int MAX_PLAYERS = 25;
    private static final int MAX_GOALKEEPERS = 25;

    private List<Goalkeeper> goalkeeperList = new ArrayList<Goalkeeper>();
    private Coach coach;
    private List<Player> playersList = new ArrayList<Player>();


    //Ajouter un nouveau joueur ou coach ou gardien dans la liste avec des contraintes définies
    public void addPlayer(Person person, Teams teamsDestination) throws TeamsFullException, PlayerAlreadySavedException, TeamBudgetMaxException, CoachAlreadyExist {
        if (person == null || teamsDestination == null)
            throw new IllegalArgumentException("Fournir les paramètres");

        //Tester le budget de l'équipe
        Utils.checkBudget(person, teamsDestination, 0);

        //Cas joueur
        if (person instanceof Player && !(person instanceof Goalkeeper)) {
            //liste des joueurs de l'équipe de destination
            playersList = teamsDestination.getPlayers();


            // playersList = teamsDestination.getPlayers();  // Now safely assign to static variable


            if (playersList != null) {
                if (playersList.size() >= MAX_PLAYERS)
                    throw new TeamsFullException("Liste de l'équipe " + teamsDestination.getName() + "pleine");

                if (playersList.contains((Player) person))
                    throw new PlayerAlreadySavedException("Joueur déjà dans la liste de " + teamsDestination.getName());
            }
            //Si tout est ok==pas d'exceptions alors
            playersList.add((Player) person);
        } else if (person instanceof Coach) {//Cas coach
            //coach l'équipe de destination s'il existe
            coach = teamsDestination.getCoach();
            if (coach != null)
                throw new CoachAlreadyExist(teamsDestination.getName() + " a dèjà un coach");
            //Ajout du coach
            teamsDestination.setCoach((Coach) person);

        } else if (person instanceof Goalkeeper) {

            goalkeeperList = teamsDestination.getGoalkeepers();
            if (goalkeeperList.size() >= MAX_GOALKEEPERS)
                throw new TeamsFullException("Liste des gardiens l'équipe " + teamsDestination.getName() + " pleine");
            if (goalkeeperList.contains((Goalkeeper) person))
                throw new PlayerAlreadySavedException("Gardien déjà dans la liste de " + teamsDestination.getName());
            //Si tout est ok==pas d'exceptions alors
            goalkeeperList.add((Goalkeeper) person);
        } else {
            throw new IllegalArgumentException("Aucune classe correspondante");
        }


        // Après ajout du joueur/gardien/coach, on met à jour le budget de l'équipe
        teamsDestination.setBudgetMax(teamsDestination.getBudgetMax() - person.getSalary());
        System.out.println(person.getClass().getName() + " " + person.getName() + "a été ajouté avec succès à l'équipe " + teamsDestination.getName());
    }


    //Retrait d'un joueur dans la liste
    public void removePlayer(Person person, Teams teamsSource) throws PlayerNotFoundException, TeamBudgetMaxException {
        if (person == null || teamsSource == null)
            throw new IllegalArgumentException("Fournir les paramètres");

        //Cas joueur
        if (person instanceof Player && !(person instanceof Goalkeeper)) {
            //liste des joueurs de l'équipe de destination
            playersList = teamsSource.getPlayers();
            if (!playersList.contains((Player) person))
                throw new PlayerNotFoundException("Joueur non présent dans la liste de l'équipe " + teamsSource.getName());
            //Si tout est ok==pas d'exceptions alors
            playersList.remove((Player) person);

        } else if (person instanceof Coach) {//Cas coach
            //coach l'équipe de destination s'il existe
            coach = teamsSource.getCoach();
            if (!coach.equals((Coach) person))
                throw new PlayerNotFoundException("Coach non présent dans l'équipe " + teamsSource.getName());
            //retrait du coach
            teamsSource.setCoach(null);

        } else if (person instanceof Goalkeeper) {

            goalkeeperList = teamsSource.getGoalkeepers();
            if (!goalkeeperList.contains((Goalkeeper) person))
                throw new PlayerNotFoundException("Gardien non présent dans la liste de l'équipe " + teamsSource.getName());
            //Si tout est ok==pas d'exceptions alors
            goalkeeperList.remove((Goalkeeper) person);
        } else {
            throw new IllegalArgumentException("Aucune classe correspondante");
        }


        // Mettre à jour le budget de l'équipe
        teamsSource.setBudgetMax(teamsSource.getBudgetMax() + person.getSalary());
        System.out.println(person.getClass().getName() + " " + person.getName() + "a été supprimé avec succès de l'équipe " + teamsSource.getName());
    }

    //Transfert d'un joueur d'une équipe à une autre
    public void transferPlayer(Person person, Teams teamsSource, Teams teamsDestination, double amountTransfer) throws PlayerNotFoundException, TeamBudgetMaxException, TeamsFullException, PlayerAlreadySavedException, CoachAlreadyExist {

        if (person == null || teamsSource == null || teamsDestination == null)
            throw new IllegalArgumentException("Fournir les paramètres");
        //Tester le budget de l'équipe
        Utils.checkBudget(person, teamsDestination, amountTransfer);

        // retirer le joueur de son équipe
        removePlayer(person, teamsSource);
        //ajouter le joueur dans la nouvelle équipe
        addPlayer(person, teamsDestination);

        // transférer la personne et mettre à jour le budget des équipes
        teamsDestination.setBudgetMax(teamsDestination.getBudgetMax() - amountTransfer);
        teamsSource.setBudgetMax(teamsSource.getBudgetMax() + amountTransfer);
        System.out.println(person.getClass().getName() + "  " + person.getName() + " a été transféré de " + teamsSource.getName() + " avec succès vers " + teamsDestination.getName());
        //Todo: comment régler le soucis de annulation de transfert si on a déjà retirer le joueur est qu'il ya une erreur dans l'ajout?? Rollback??
    }


    //Retirer une teams de la liste
    public void removeTeams(Teams teams) throws Exception {
        if (teams == null)
            throw new IllegalArgumentException("Fournir le paramètre");

        //On recupere le liste des équipes
        List<Teams> allTeams = TestingTeams.getTeamsList();
        if (allTeams.isEmpty())
            throw new Exception("Liste d'équipe vide");

        //pas de soucis next step
        allTeams.remove(teams);
        System.out.println("Équipe " + teams.getName() + " retiré avec succès");
    }
}
//TODO: Comment regler le soucis de transfert si on a retirer le joueur est qu'il ya une erreur dans l'ajout?? Rollback??




