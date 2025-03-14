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


            Coach ancelotti = new Coach(
                    "Carlo", "Ancelotti",
                    LocalDate.parse("1959-06-10", formatter),
                    3_200_000,
                    "Italien",
                    78.0, 1.78,
                    25, 30,
                    Arrays.asList(StyleOfGame.PRESSING_HAUT, StyleOfGame.CONTRE_ATTAQUE),
                    Licence.UEFA_PRO
            );

            Coach zidane = new Coach(
                    "Zinedine", "Zidane",
                    LocalDate.parse("1972-06-23", formatter),
                    3_500_000,
                    "Français",
                    81.0, 1.85,
                    20, 25,
                    Arrays.asList(StyleOfGame.TIKI_TAKA, StyleOfGame.JEU_SUR_LES_AILES),
                    Licence.UEFA_A
            );

            Coach simone = new Coach(
                    "Diego", "Simeone",
                    LocalDate.parse("1970-04-28", formatter),
                    4_000_000,
                    "Argentin",
                    80.0, 1.77,
                    30, 35,
                    Arrays.asList(StyleOfGame.BETON_DEFENSIF, StyleOfGame.PRESSING_HAUT),
                    Licence.PRO
            );

            Coach conte = new Coach(
                    "Antonio", "Conte",
                    LocalDate.parse("1969-07-31", formatter),
                    2_900_000,
                    "Italien",
                    79.0, 1.78,
                    28, 30,
                    Arrays.asList(StyleOfGame.CONTRE_ATTAQUE, StyleOfGame.PRESSING_HAUT),
                    Licence.PRO
            );
            Coach deschamps = new Coach(
                    "Didier", "Deschamps",
                    LocalDate.parse("1968-10-15", formatter),
                    3_500_000,
                    "Français",
                    76.0, 1.74,
                    25, 28,
                    Arrays.asList(StyleOfGame.BETON_DEFENSIF, StyleOfGame.CONTRE_ATTAQUE),
                    Licence.UEFA_PRO
            );

            coaches.add(mourinho);
            coaches.addAll(List.of(klopp,guardiola,ancelotti,zidane,simone,conte));
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
