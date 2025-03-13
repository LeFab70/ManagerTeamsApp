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

        System.out.println("========================Foot Manager testing====================");
           //Testing
        List<Player> allPlayers=TestingPlayers.createSomePlayers();
        List<Teams> allTeams= TestingTeams.createSomeTeams();
        List<Coach> allCoach= TestingCoach.createSomeCoach();
        List<Goalkeeper> allGoalKeepers= TestingGoalKeepers.createSomeGoalKeepers();
        //Testing.createSomeGoalKeepers();
        System.out.println("========================All Teams====================");
        Utils.displayObject(allTeams);
        System.out.println("========================All Players====================");
        Utils.displayObject(allPlayers);
        System.out.println("========================All coachs===================");
        Utils.displayObject(allCoach);
        System.out.println("========================All Keepers====================");
        Utils.displayObject(allGoalKeepers);

        TestingManagerTeams teams=new TestingManagerTeams();
        teams.addPlayers();
        Utils.displayObject(allTeams);
    }
}
