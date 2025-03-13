import entities.Goalkeeper;
import entities.Teams;
import enums.FieldPosition;
import testGlobale.Testing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("========================Foot Manager testing====================");
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");



        //Testing

        //Create some players
       // Testing.createSomePlayers();
        List<Teams> allTeams=Testing.createSomeTeams();
        //Testing.createSomeCoach();
        //Testing.createSomeGoalKeepers();

        //afficher liste Équipes
        for (Teams teams:allTeams)
        {
            System.out.println(teams);
        }


    }
}
