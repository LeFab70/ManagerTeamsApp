package testGlobale;

import entities.Player;
import enums.FieldPosition;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Player> getPlayerList()
    {
        return playerList;
    }
}
