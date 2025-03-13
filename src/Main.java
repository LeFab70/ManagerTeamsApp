import controller.ManageTeams;
import entities.Coach;
import entities.Goalkeeper;
import entities.Player;
import entities.Teams;
import testGlobale.*;
import utils.Utils;

import java.time.format.DateTimeFormatter;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        final ManageTeams manageTeamsController=new ManageTeams();
        System.out.println("========================Foot Manager testing====================");

        //Testing

        //Remplir les données et les stocker dans les listes
        List<Player> allPlayers=TestingPlayers.createSomePlayers();
        List<Teams> allTeams= TestingTeams.createSomeTeams();
        List<Coach> allCoach= TestingCoach.createSomeCoach();
        List<Goalkeeper> allGoalKeepers= TestingGoalKeepers.createSomeGoalKeepers();

        //Premier affichage pour voir si tout est ok
        System.out.println("========================All Teams====================");
        Utils.displayObject(allTeams);
        System.out.println("========================All Players====================");
        Utils.displayObject(allPlayers);
        System.out.println("========================All coachs===================");
        Utils.displayObject(allCoach);
        System.out.println("========================All Keepers====================");
        Utils.displayObject(allGoalKeepers);

        //Add Player in teams 1
        manageTeamsController.addPlayer(allPlayers.get(1), allTeams.get(0));
        manageTeamsController.addPlayer(allPlayers.get(2), allTeams.get(0));
        //Add GoalKeepers in teams
        manageTeamsController.addPlayer(allGoalKeepers.get(1), allTeams.get(0));
        //Add Coach in team
        manageTeamsController.addPlayer(allCoach.get(1), allTeams.get(0));

        //Afficher le résultat pour la team 1
        System.out.println(allTeams.get(0));


        //Test de transfert player
        manageTeamsController.transferPlayer(allPlayers.get(1), allTeams.get(0), allTeams.get(1), 1200);

        //Afficher les résultats de toutes les teams
        Utils.displayObject(allTeams);
    }
}
