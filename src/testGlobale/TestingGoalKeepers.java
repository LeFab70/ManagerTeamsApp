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
    public static List<Goalkeeper> createSomeGoalKeepers() throws SalaryException, DateOfBirthException {
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
            goalkeeperList.add(neuer);
            goalkeeperList.add(buffon);
            goalkeeperList.add(casillas);

            return goalkeeperList;
        } catch (SalaryException e) {
            throw new SalaryException(e.getMessage());
        } catch (DateOfBirthException d) {
            throw new DateOfBirthException(d.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
