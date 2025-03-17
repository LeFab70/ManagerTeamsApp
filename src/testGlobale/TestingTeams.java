package testGlobale;

import entities.*;

import java.util.ArrayList;

import java.util.List;

public class TestingTeams {

    private static final List<Teams> teamsList=new ArrayList<>();
    //Create some teams
    public static void createSomeTeams() {
        try {
            // Création de 4 équipes célèbres avec un budget défini
            Teams realMadrid = new Teams("Real Madrid", 18_000_000);
            Teams barcelona = new Teams("FC Barcelona", 17_500_000);
            Teams valencia = new Teams("Valencia CF", 14_500_000);
            Teams sevilla = new Teams("Sevilla FC", 15_500_000);
            Teams villarreal = new Teams("Villarreal CF", 150_000_000);
            Teams realSociedad = new Teams("Real Sociedad", 130_000_000);
            Teams realBetis = new Teams("Real Betis", 125_000_000);
            Teams celtaVigo = new Teams("Celta Vigo", 100_000_000);
            teamsList.addAll(List.of(realMadrid,barcelona,sevilla,valencia,villarreal,realSociedad,realBetis,celtaVigo));

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Teams> getTeamsList()
    {
        return  teamsList;
    }

}
