package utils;

import entities.Person;
import entities.Teams;
import exceptions.TeamBudgetMaxException;

import java.util.List;

//Méthodes utilitaires
public class Utils {


    //Check budget du club
    public static void checkBudget(Person person, Teams teams,double amountTransfer) throws TeamBudgetMaxException {
        //Tester le budget du club destination
        double budgetActuel = teams.getBudgetMax();
        double salaryNewPlayer = person.getSalary();
        if (salaryNewPlayer + amountTransfer > budgetActuel)
            throw new TeamBudgetMaxException("Le budget du club est insuffisant pour se procurer " + person.getName());
    }

    //Display content of list of objects
    public static void displayObject(List<?> object)
    {
        for (Object item:object)
        {
            System.out.println(item);
        }
    }
}
