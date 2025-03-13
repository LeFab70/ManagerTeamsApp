package testGlobale;

import entities.*;

import java.util.ArrayList;

import java.util.List;

public class TestingTeams {

    private static final List<Teams> teamsList=new ArrayList<>();
    //Create some teams
    public static List<Teams> createSomeTeams() {
        try {
            // Création de 4 équipes célèbres avec un budget défini
            Teams realMadrid = new Teams("Real Madrid", 18_000_000);
            Teams barcelona = new Teams("FC Barcelona", 17_500_000);
            Teams valencia = new Teams("Valencia CF", 14_500_000);
            Teams sevilla = new Teams("Sevilla FC", 15_500_000);

            teamsList.add(realMadrid);
            teamsList.add(barcelona);
            teamsList.add(sevilla);
            teamsList.add(valencia);
           return teamsList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
