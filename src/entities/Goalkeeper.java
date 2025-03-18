/**
 * La classe Goalkeeper représente un joueur spécialisé en tant que gardien de but,
 * héritant des caractéristiques générales d'un joueur et ajoutant des attributs spécifiques
 * comme les réflexes, le nombre de penalties arrêtés, de buts sauvés et encaissés, ainsi que la capacité à jouer avec les pieds.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Suit les statistiques clés pour évaluer les performances du gardien.</li>
 *     <li>Gère les compétences spécifiques comme les réflexes et le jeu au pied.</li>
 *     <li>Hérite des caractéristiques de la classe Player (nom, date de naissance, position, etc.).</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
package entities;

import enums.FieldPosition;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;

public class Goalkeeper extends Player{
    private int reflexes; // note de 0 sur 10
    private int numberOfPenaltiesSaved;
    private int numberOfGoalsSaved;
    private int numberOfGoalsConceded;
    private int footPaying; // capacité à jouer avec les pieds sur une échelle de 0 à 10


    /**
     * Constructeur complet permettant de créer un gardien de but avec toutes ses caractéristiques.
     *
     * @param name              Nom du gardien.
     * @param surname           Prénom du gardien.
     * @param dateOfBirth       Date de naissance du gardien.
     * @param salary            Salaire du gardien.
     * @param nationality       Nationalité du gardien.
     * @param weight            Poids du gardien.
     * @param height            Taille du gardien.
     * @param numberOfPass      Nombre de passes réussies.
     * @param numberOfGoals     Nombre de buts marqués (rare pour un gardien).
     * @param number            Numéro de maillot.
     * @param talent            Niveau de talent du gardien.
     * @param fieldPosition     Position sur le terrain (devrait être Goalkeeper).
     * @param reflexes          Note de réflexes de 0 à 10.
     * @param numberOfPenaltiesSaved  Nombre de penalties arrêtés.
     * @param numberOfGoalsSaved      Nombre de tirs sauvés.
     * @param numberOfGoalsConceded   Nombre de buts encaissés.
     * @param footPaying        Capacité à jouer avec les pieds (note de 0 à 10).
     * @throws DateOfBirthException   Si la date de naissance est invalide (moins de 18 ans).
     * @throws SalaryException        Si le salaire est négatif.
     */

    public Goalkeeper(String name, String surname, LocalDate dateOfBirth, double salary, String nationality, double weight, double height, int numberOfPass, int numberOfGoals, int number, String talent, FieldPosition fieldPosition, int reflexes, int numberOfPenaltiesSaved, int numberOfGoalsSaved, int numberOfGoalsConceded, int footPaying) throws DateOfBirthException, SalaryException {
        super(name, surname, dateOfBirth, salary, nationality, weight, height, numberOfPass, numberOfGoals, number, talent, fieldPosition);
        this.reflexes = reflexes;
        this.numberOfPenaltiesSaved = numberOfPenaltiesSaved;
        this.numberOfGoalsSaved = numberOfGoalsSaved;
        this.numberOfGoalsConceded = numberOfGoalsConceded;
        this.footPaying = footPaying;
    }

    public Goalkeeper() {
       super();
    }

    public int getReflexes() {
        return reflexes;
    }

    public void setReflexes(int reflexes) {
        this.reflexes = reflexes;
    }

    public int getNumberOfPenaltiesSaved() {
        return numberOfPenaltiesSaved;
    }

    public void setNumberOfPenaltiesSaved(int numberOfPenaltiesSaved) {
        this.numberOfPenaltiesSaved = numberOfPenaltiesSaved;
    }

    public int getNumberOfGoalsSaved() {
        return numberOfGoalsSaved;
    }

    public void setNumberOfGoalsSaved(int numberOfGoalsSaved) {
        this.numberOfGoalsSaved = numberOfGoalsSaved;
    }

    public int getNumberOfGoalsConceded() {
        return numberOfGoalsConceded;
    }

    public void setNumberOfGoalsConceded(int numberOfGoalsConceded) {
        this.numberOfGoalsConceded = numberOfGoalsConceded;
    }

    public int getFootPaying() {
        return footPaying;
    }

    public void setFootPaying(int footPaying) {
        this.footPaying = footPaying;
    }

    @Override
    public String toString() {
        return "Goalkeeper{" +
                super.toString()+
                "  reflexes=" + reflexes +
                ", numberOfPenaltiesSaved=" + numberOfPenaltiesSaved +
                ", numberOfGoalsSaved=" + numberOfGoalsSaved +
                ", numberOfGoalsConceded=" + numberOfGoalsConceded +
                ", footPaying=" + footPaying +
                '}';
    }
}
