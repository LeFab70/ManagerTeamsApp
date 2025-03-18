/**
 * La classe Teams représente une équipe de football.
 * Elle contient une liste de joueurs, de gardiens de but, un entraîneur et un budget maximum.
 * Un identifiant unique est généré automatiquement pour chaque équipe créée.
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Gère une équipe composée de joueurs et de gardiens.</li>
 *     <li>Assigne un coach à l'équipe.</li>
 *     <li>Dispose d'un budget maximal pour encadrer les dépenses.</li>
 *     <li>Génère un identifiant unique pour chaque nouvelle équipe.</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */

package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Teams {
    private final static AtomicInteger count = new AtomicInteger(1);
    private int id;
    private String name;
    private List<Player> players=new ArrayList<>();
    private List<Goalkeeper> goalkeepers=new ArrayList<>();
    private double budgetMax;
    private Coach coach;

    /**
     * Constructeur permettant de créer une nouvelle équipe avec un nom et un budget.
     * Un identifiant unique est automatiquement généré.
     *
     * @param name      Nom de l'équipe.
     * @param budgetMax Budget maximum alloué à l'équipe.
     */
    //les players ainsi que les gardiens seront ajoutés suivant les méthodes statiques définies dans gestionEquipe
    public Teams( String name, double budgetMax) {
        this.id = count.getAndIncrement();
        this.name = name;
        this.budgetMax = budgetMax;
    }
    /**
     * Entraîneur de l'équipe.
     */

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Teams() {
        this.id = count.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Goalkeeper> getGoalkeepers() {
        return goalkeepers;
    }

    public void setGoalkeepers(List<Goalkeeper> goalkeepers) {
        this.goalkeepers = goalkeepers;
    }
    /**
     * Budget maximum alloué à l'équipe.
     */
    public double getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(double budgetMax) {
        this.budgetMax = budgetMax;
    }

    @Override
    public String toString() {
        return "Teams{" +
                " id= " + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", goalkeepers=" + goalkeepers +
                ", budgetMax=" + budgetMax +
                " Coach= "+coach+
                '}';
    }
}
