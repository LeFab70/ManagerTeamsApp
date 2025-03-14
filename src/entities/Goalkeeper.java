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
