/**
 * La classe {@code Utils} fournit des méthodes utilitaires pour la gestion de divers aspects du jeu,
 * y compris la vérification du budget d'un club, l'affichage de listes d'objets et la génération de matchs
 * aléatoires entre équipes.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Vérification du budget d'un club avant un transfert de joueur.</li>
 *     <li>Affichage du contenu d'une liste d'objets.</li>
 *     <li>Génération aléatoire de matchs entre équipes avec score et date.</li>
 * </ul>
 *
 * <h2>Exemple d'utilisation :</h2>
 * <pre>
 *     // Vérification du budget d'un club
 *     Utils.checkBudget(person, team, amountTransfer);
 *
 *     // Affichage d'une liste d'objets
 *     Utils.displayObject(myList);
 *
 *     // Génération d'un match aléatoire
 *     Game game = Utils.teamsGames();
 * </pre>
 *
 * @author Fabrice Kouonang
 * @version 1.0
 * @since 2025
 */
package utils;

import entities.Game;
import entities.Person;
import entities.Teams;
import exceptions.TeamBudgetMaxException;
import testGlobale.TestingTeams;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Méthodes utilitaires
public class Utils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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


    //Random Teams
    public static Game teamsGames() throws FileNotFoundException {
        //Valeurs intervalles des nombres aléatoires

        List<Teams> allTeams=TestingTeams.getTeamsList(); //Liste des toutes les équipes
        final int MAX_RANDOM = allTeams.size()-1;//Valeur pour toute la liste des équipes
        final int MIN_RANDOM =0;  //premiere valeur possible pour la teams[0]
        int randomNumberReceive = (int) (Math.random() * (MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM);
        int randomNumberVisitor =randomNumberReceive;
        int scoreVisitorTeams=(int) (Math.random()*9+1); //pour générer un nombre de buts marqués pour l'équipe visiteur entre 0 et 10
        int scoreReceptionTeams=(int) (Math.random()*9+1); //pour générer un nombre de buts marqués pour l'équipe qui reçoit entre 0 et 10
        Teams teamsReceived=allTeams.get(randomNumberReceive);

        //Obliger un autre random tant quon a la même équipe qui est tiré
        do {
            randomNumberVisitor = (int) (Math.random() * (MAX_RANDOM - MIN_RANDOM + 1) + MIN_RANDOM);
        } while (randomNumberReceive==randomNumberVisitor);
        Teams teamsVisitor=allTeams.get(randomNumberVisitor);

        //Mise à jour du match et retour des valeurs pour saving
        return new Game(teamsReceived.getName(),teamsVisitor.getName(),scoreReceptionTeams,scoreVisitorTeams, LocalDate.parse(LocalDate.now().toString(), formatter),"Fabrice Kouonang");

    }
}
