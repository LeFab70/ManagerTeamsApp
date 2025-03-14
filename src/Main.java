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
        System.out.println("\n\n========================General datas====================\n\n");
        System.out.println("\n\n========================All Teams====================\n");
        Utils.displayObject(allTeams);
        System.out.println("\n\n========================All Players====================\n");
        Utils.displayObject(allPlayers);
        System.out.println("\n\n========================All coachs===================\n");
        Utils.displayObject(allCoach);
        System.out.println("\n\n========================All Keepers====================\n");
        Utils.displayObject(allGoalKeepers);

        System.out.println("\n\n========================Add players Coach and keepers to the teams====================\n");


        for (int indexTeam = 0; indexTeam <allTeams.size() ; indexTeam++) {

            //== 1 coach par team et 1 keeper par team=====
            //Add GoalKeepers in teams
            manageTeamsController.addPlayer(allGoalKeepers.get(indexTeam), allTeams.get(indexTeam));
            //Add Coach in team
            manageTeamsController.addPlayer(allCoach.get(indexTeam), allTeams.get(indexTeam));

            //Add Player in teams
            //== 3 players par team
            for (int indexPlayer = 0; indexPlayer <allPlayers.size() ; indexPlayer++) {
                manageTeamsController.addPlayer(allPlayers.get(indexPlayer), allTeams.get(indexTeam));
                manageTeamsController.addPlayer(allPlayers.get(indexPlayer), allTeams.get(indexTeam));
            }


        }


        //Afficher le résultat pour la team 1
        System.out.println(allTeams.get(0));


        //Test de transfert player
        manageTeamsController.transferPlayer(allPlayers.get(1), allTeams.get(0), allTeams.get(1), 1200);

        //Afficher les résultats de toutes les teams
        Utils.displayObject(allTeams);
    }
}
