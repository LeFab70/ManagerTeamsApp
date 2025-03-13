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

    //les players ainsi que les gardiens seront ajoutés suivant les méthodes statiques définies dans gestionEquipe
    public Teams( String name, double budgetMax) {
        this.id = count.getAndIncrement();
        this.name = name;
        this.budgetMax = budgetMax;
    }

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

    public double getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(double budgetMax) {
        this.budgetMax = budgetMax;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                ", goalkeepers=" + goalkeepers +
                ", budgetMax=" + budgetMax +
                " Coach= "+coach+
                '}';
    }
}
