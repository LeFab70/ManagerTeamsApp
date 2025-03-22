
package testGlobale;

import entities.*;

import java.util.ArrayList;

import java.util.List;
/**
 * La classe {@code TestingTeams} permet de créer une liste d'équipes célèbres avec un budget défini,
 * et de les manipuler via une liste statique.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Crée plusieurs équipes célèbres avec un budget défini.</li>
 *     <li>Fournit une méthode pour récupérer la liste de toutes les équipes créées.</li>
 * </ul>
 *
 * <h2>Exemple d'utilisation :</h2>
 * <pre>
 *     TestingTeams.createSomeTeams();  // Crée les équipes
 *     List<Teams> teams = TestingTeams.getTeamsList();  // Récupère la liste des équipes créées
 * </pre>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
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

    /**
     * Récupère la liste de tous les Teams créés.
     *
     * @return Liste des Teams.
     */
    public static List<Teams> getTeamsList()
    {
        return  teamsList;
    }

}
