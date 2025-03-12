/**
 * @author Fabrice
 * @version 1.0
 * @retun 0
 */
package controller;

import entities.Player;
import entities.Teams;
import exceptions.PlayerAlreadySavedException;
import exceptions.TeamsFullException;


import java.util.List;

public class ManageTeams {


    public void addPlayer(Player player, Teams teamsDestination) throws TeamsFullException, PlayerAlreadySavedException {
        List<Player> players=teamsDestination.getPlayers();
        if (player ==null)
            throw new NullPointerException("Le joueur n'est pas définir");
        if (players.size()>=25)
            throw new TeamsFullException("Liste de l'équipe pleine");
        if(players.contains(player))
            throw new PlayerAlreadySavedException("Joueur déjà dans la liste");

        //todo: tester le budget du club par rapport au salaire du joueur

        players.add(player);
        System.out.println("le joueur a été ajouté avec succès");
    }

    public void removePlayer(Player player, Teams teamsSource){
        //Bruno;

    }
    public void transferPlayer(Player player, Teams teamsSource,Teams teamsDestination, double amountTransfer){}

}
