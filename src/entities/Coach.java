package entities;
/**
 * La classe Coach hérite de la classe Person et représente un entraîneur avec des informations spécifiques
 * comme le nombre d'années d'expérience, les titres remportés, le style de jeu et la licence.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Gère l'expérience et les titres du coach.</li>
 *     <li>Supporte différents styles de jeu et types de licence.</li>
 *     <li>Hérite des informations personnelles de la classe Person.</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
import enums.Licence;
import enums.StyleOfGame;
import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.util.List;

public class Coach extends Person{
    private int numberOfYearsExperience;
    private int numberOfTitle;
    private List<StyleOfGame> styleOfGame;
    private Licence licence;

    public Coach(String name, String surname, LocalDate dateOfBirth, double salary, String nationality, double weight, double height, int numberOfYearsExperience, int numberOfTitle, List<StyleOfGame> styleOfGame, Licence licence) throws DateOfBirthException, SalaryException {
        super(name, surname, dateOfBirth, salary, nationality, weight, height);
        this.numberOfYearsExperience = numberOfYearsExperience;
        this.numberOfTitle = numberOfTitle;
        this.styleOfGame = styleOfGame;
        this.licence = licence;
    }

    public Coach() {
        super();
    }

    public int getNumberOfYearsExperience() {
        return numberOfYearsExperience;
    }

    public void setNumberOfYearsExperience(int numberOfYearsExperience) {
        this.numberOfYearsExperience = numberOfYearsExperience;
    }

    public int getNumberOfTitle() {
        return numberOfTitle;
    }

    public void setNumberOfTitle(int numberOfTitle) {
        this.numberOfTitle = numberOfTitle;
    }

    public List<StyleOfGame> getStyleOfGame() {
        return styleOfGame;
    }

    public void setStyleOfGame(List<StyleOfGame> styleOfGame) {
        this.styleOfGame = styleOfGame;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Coach{" +
                super.toString()+
                "  numberOfYearsExperience=" + numberOfYearsExperience +
                ", numberOfTitle=" + numberOfTitle +
                ", styleOfGame=" + styleOfGame +
                ", licence=" + licence +
                '}';
    }
}
