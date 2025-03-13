package testGlobale;

import controller.ManageTeams;
import entities.Coach;
import entities.Goalkeeper;
import entities.Player;
import entities.Teams;
import exceptions.CoachAlreadyExist;
import exceptions.PlayerAlreadySavedException;
import exceptions.TeamBudgetMaxException;
import exceptions.TeamsFullException;
import utils.Utils;


import java.util.List;

public class TestingManagerTeams {

   // private final ManageTeams manageTeamsController=new ManageTeams();
    private static List<Player> allPlayers;
    private static List<Coach> allCoach;
    private static List<Goalkeeper> allGoalKeepers;
    private static List<Teams> allTeams;
    {
        try
        {
            allPlayers = TestingPlayers.createSomePlayers();
            allTeams= TestingTeams.createSomeTeams();
            allCoach = TestingCoach.createSomeCoach();
            allGoalKeepers = TestingGoalKeepers.createSomeGoalKeepers();
        }
       catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Add player
   public void addPlayers() throws TeamBudgetMaxException, CoachAlreadyExist, TeamsFullException, PlayerAlreadySavedException {
        ManageTeams.addPlayer(allPlayers.get(1), allTeams.get(1));
   }

   //Add GoalKeeper
    public void addGoalKeepers() throws TeamBudgetMaxException, CoachAlreadyExist, TeamsFullException, PlayerAlreadySavedException {
        ManageTeams.addPlayer(allGoalKeepers.get(1), allTeams.get(1));
    }

    //Add coach
    public void addCoach() throws TeamBudgetMaxException, CoachAlreadyExist, TeamsFullException, PlayerAlreadySavedException {
        ManageTeams.addPlayer(allCoach.get(1), allTeams.get(1));
    }


}
