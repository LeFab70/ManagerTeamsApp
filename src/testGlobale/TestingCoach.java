package testGlobale;

import entities.Coach;
import enums.Licence;
import enums.StyleOfGame;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingCoach {
    private static final List<Coach> coaches=new ArrayList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //Create some Coach
    public static List<Coach> createSomeCoach() throws SalaryException, DateOfBirthException {
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
        coaches.add(mourinho);
            coaches.add(klopp);
            coaches.add(guardiola);
        return coaches;

        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
