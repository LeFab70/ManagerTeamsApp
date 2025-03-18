/**
 * La classe Player représente un joueur de football, héritant des caractéristiques d'une Personne
 * et ajoutant des attributs spécifiques comme la position, le talent, le numéro de maillot,
 * ainsi que les statistiques de buts et de passes.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Gère la position du joueur sur le terrain.</li>
 *     <li>Inclut les statistiques individuelles (buts, passes).</li>
 *     <li>Évalue le talent du joueur sur une échelle de 0 à 10.</li>
 *     <li>Assure la validation du salaire et de la date de naissance via des exceptions personnalisées.</li>
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

public class Player extends Person{
    private FieldPosition fieldPosition;
    private String talent;  //sur une échelle de 0 à 10
    private int number; //numéro maillot
    private int numberOfGoals;
    private int numberOfPass;

    /**
     * Constructeur complet permettant d'initialiser un joueur avec toutes ses caractéristiques.
     *
     * @param name          Nom du joueur.
     * @param surname       Prénom du joueur.
     * @param dateOfBirth   Date de naissance du joueur.
     * @param salary        Salaire du joueur.
     * @param nationality   Nationalité du joueur.
     * @param weight        Poids du joueur (en kg).
     * @param height        Taille du joueur (en m).
     * @param numberOfPass  Nombre de passes réussies par le joueur.
     * @param numberOfGoals Nombre de buts marqués par le joueur.
     * @param number        Numéro de maillot du joueur.
     * @param talent        Niveau de talent du joueur (sur une échelle de 0 à 10).
     * @param fieldPosition Position du joueur sur le terrain (défenseur, attaquant, etc.).
     * @throws DateOfBirthException Si la date de naissance est invalide (par exemple, si le joueur est trop jeune).
     * @throws SalaryException      Si le salaire est négatif ou nul.
     */

    public Player(String name, String surname, LocalDate dateOfBirth, double salary, String nationality, double weight, double height, int numberOfPass, int numberOfGoals, int number, String talent, FieldPosition fieldPosition) throws DateOfBirthException, SalaryException {
        super(name, surname, dateOfBirth, salary, nationality, weight, height);
        if (dateOfBirth == null) {
            throw new DateOfBirthException("La date de naissance ne peut pas être nulle.");
        }

        if (salary <= 0) {
            throw new SalaryException("Le salaire doit être supérieur à zéro.");
        }
        this.numberOfPass = numberOfPass;
        this.numberOfGoals = numberOfGoals;
        this.number = number;
        this.talent = talent;
        this.fieldPosition = fieldPosition;
    }

    public Player() {
        super();
    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(FieldPosition fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public int getNumberOfPass() {
        return numberOfPass;
    }

    public void setNumberOfPass(int numberOfPass) {
        this.numberOfPass = numberOfPass;
    }

    @Override
    public String toString() {
        return "Player{" +
                super.toString()+
                "  fieldPosition=" + fieldPosition +
                ", talent='" + talent + '\'' +
                ", number=" + number +
                ", numberOfGoals=" + numberOfGoals +
                ", numberOfPass=" + numberOfPass +
                '}';
    }
}
