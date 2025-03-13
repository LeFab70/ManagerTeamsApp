package testGlobale;

import entities.*;
import enums.FieldPosition;
import enums.Licence;
import enums.StyleOfGame;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testing {

    //Date formatter
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static List<Coach> coaches=new ArrayList<>();
    private static List<Teams> teamsList=new ArrayList<>();
    private static List<Goalkeeper> goalkeeperList=new ArrayList<>();
    private static List<Player> playerList=new ArrayList<>();
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

        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Create some teams
    public static List<Teams> createSomeTeams() {
        try {
            // Création de 4 équipes célèbres avec un budget défini
            Teams realMadrid = new Teams("Real Madrid", 8_000_000);
            Teams barcelona = new Teams("FC Barcelona", 7_500_000);
            Teams valencia = new Teams("Valencia CF", 4_500_000);
            Teams sevilla = new Teams("Sevilla FC", 5_500_000);

            teamsList.add(realMadrid);
            teamsList.add(barcelona);
            teamsList.add(sevilla);
            teamsList.add(valencia);
           return teamsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Create some GoalKeepers
    public static void createSomeGoalKeepers() throws SalaryException, DateOfBirthException {
        try {
            // Création de trois gardiens légendaires
            Goalkeeper buffon = new Goalkeeper(
                    "Gianluigi", "Buffon",
                    LocalDate.parse("1978-01-28", formatter),  // Utilisation du formatter pour convertir la chaîne en LocalDate
                    2_000_000,
                    "Italien",
                    92.0, 1.92,
                    150, 0,
                    1, "Légendaire",
                    FieldPosition.GARDIEN,
                    10, 35,
                    500, 300,
                    7
            );

            Goalkeeper casillas = new Goalkeeper(
                    "Iker", "Casillas",
                    LocalDate.parse("1981-05-20", formatter),
                    1_800_000,
                    "Espagnol",
                    84.0, 1.85,
                    120, 0,
                    1, "Muraille",
                    FieldPosition.GARDIEN,
                    9, 25,
                    450, 280,
                    8
            );

            Goalkeeper neuer = new Goalkeeper(
                    "Manuel", "Neuer",
                    LocalDate.parse("1986-03-27", formatter),
                    2_500_000,
                    "Allemand",
                    88.0, 1.93,
                    200, 0,
                    1, "Libéro-Gardien",
                    FieldPosition.GARDIEN,
                    10, 40,
                    600, 250,
                    10
            );
        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Create some Coach
    public static void createSomeCoach() throws SalaryException, DateOfBirthException {
        try {
            // Création de trois coachs légendaires
            Coach guardiola = new Coach(
                    "Pep", "Guardiola",
                    LocalDate.parse("1971-01-18", formatter),
                    3_000_000,
                    "Espagnol",
                    75.0, 1.80,
                    20, 35,
                    Arrays.asList(StyleOfGame.CONTRE_ATTAQUE, StyleOfGame.BETON_DEFENSIF),
                    Licence.PRO
            );

            Coach mourinho = new Coach(
                    "José", "Mourinho",
                    LocalDate.parse("1963-01-26", formatter),
                    2_500_000,
                    "Portugais",
                    80.0, 1.76,
                    25, 30,
                    Arrays.asList(StyleOfGame.TIKI_TAKA, StyleOfGame.CONTRE_ATTAQUE),
                    Licence.UEFA_PRO
            );

            Coach klopp = new Coach(
                    "Jürgen", "Klopp",
                    LocalDate.parse("1967-06-16", formatter),
                    2_800_000,
                    "Allemand",
                    83.0, 1.91,
                    22, 25,
                    Arrays.asList(StyleOfGame.JEU_SUR_LES_AILES, StyleOfGame.PRESSING_HAUT),
                    Licence.UEFA_A
            );

        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
