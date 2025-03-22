
package testGlobale;

import entities.Player;
import enums.FieldPosition;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe {@code TestingPlayers} permet de créer une liste de joueurs célèbres, de les manipuler via une liste statique,
 * et de gérer les exceptions liées aux salaires et aux dates de naissance.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Crée plusieurs joueurs célèbres avec des informations telles que le nom, la date de naissance, le salaire, la nationalité, etc.</li>
 *     <li>Vérifie la validité des salaires et des dates de naissance à travers des exceptions personnalisées {@link SalaryException} et {@link DateOfBirthException}.</li>
 *     <li>Fournit une méthode pour récupérer la liste de tous les joueurs créés.</li>
 * </ul>
 *
 * <h2>Exemple d'utilisation :</h2>
 * <pre>
 *     TestingPlayers.createSomePlayers();  // Crée les joueurs
 *     List<Player> players = TestingPlayers.getPlayerList();  // Récupère la liste des joueurs créés
 * </pre>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
public class TestingPlayers {
    private static final List<Player> playerList=new ArrayList<>();
    //Date formatter
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //Add players
    public static void createSomePlayers() throws Exception {
        try {
            // Création de players
            Player ronaldo = new Player(
                    "Cristiano", "Ronaldo",
                    LocalDate.parse("1985-02-05", formatter),  // Utilisation du formatter pour convertir la chaîne en LocalDate
                    3000000, "Portugal",
                    83.0, 1.87,
                    150, 820,
                    7, "Finisseur hors pair",
                    FieldPosition.ATTAQUANT
            );

            Player messi = new Player(
                    "Lionel", "Messi",
                    LocalDate.parse("1987-06-24", formatter),
                    3500000, "Argentine",
                    72.0, 1.70,
                    180, 810,
                    10, "Dribbleur génial",
                    FieldPosition.MILIEU_OFFENSIF
            );

            Player ramos = new Player(
                    "Sergio", "Ramos",
                    LocalDate.parse("1986-03-30", formatter),
                    1500000, "Espagne",
                    82.0, 1.84,
                    50, 100,
                    4, "Défenseur impassable",
                    FieldPosition.DEFENSEUR_CENTRAL
            );

            playerList.add(messi);
            playerList.add(ronaldo);
            playerList.add(ramos);

           // return playerList;

        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * Récupère la liste de tous les Players créés.
     *
     * @return Liste des Players.
     */
    public static List<Player> getPlayerList()
    {
        return playerList;
    }
}
