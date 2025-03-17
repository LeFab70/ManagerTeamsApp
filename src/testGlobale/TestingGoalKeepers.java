package testGlobale;

import entities.Goalkeeper;
import enums.FieldPosition;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestingGoalKeepers {
    private static final List<Goalkeeper> goalkeeperList=new ArrayList<>();
    //Date formatter
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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


            Goalkeeper cech = new Goalkeeper(
                    "Petr", "Cech",
                    LocalDate.parse("1982-05-20", formatter),
                    1_900_000,
                    "Tchèque",
                    90.0, 1.96,
                    220, 0,
                    1, "Casque d'acier",
                    FieldPosition.GARDIEN,
                    9, 28,
                    500, 270,
                    9
            );

            Goalkeeper vanDerSar = new Goalkeeper(
                    "Edwin", "van der Sar",
                    LocalDate.parse("1970-10-29", formatter),
                    1_700_000,
                    "Néerlandais",
                    85.0, 1.97,
                    210, 0,
                    1, "Mur Orange",
                    FieldPosition.GARDIEN,
                    8, 30,
                    550, 320,
                    8
            );

            Goalkeeper barthez = new Goalkeeper(
                    "Fabien", "Barthez",
                    LocalDate.parse("1971-06-28", formatter),
                    1_600_000,
                    "Français",
                    81.0, 1.80,
                    130, 0,
                    1, "Le Divin Chauve",
                    FieldPosition.GARDIEN,
                    7, 22,
                    400, 240,
                    7
            );

            Goalkeeper oblack = new Goalkeeper(
                    "Jan", "Oblak",
                    LocalDate.parse("1993-01-07", formatter),
                    3_000_000,
                    "Slovène",
                    87.0, 1.88,
                    250, 0,
                    1, "Le Mur de Madrid",
                    FieldPosition.GARDIEN,
                    10, 42,
                    450, 310,
                    9
            );

            Goalkeeper courtois = new Goalkeeper(
                    "Thibaut", "Courtois",
                    LocalDate.parse("1992-05-11", formatter),
                    2_800_000,
                    "Belge",
                    96.0, 1.99,
                    240, 0,
                    1, "La Tour Belge",
                    FieldPosition.GARDIEN,
                    10, 38,
                    480, 290,
                    10
            );



            goalkeeperList.add(neuer);
            goalkeeperList.add(buffon);
            goalkeeperList.addAll(List.of(casillas,cech,vanDerSar,barthez,oblack,courtois));
           // return goalkeeperList;
        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Goalkeeper> getGoalkeeperList()
    {
        return goalkeeperList;
    }

}
