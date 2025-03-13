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
                "fieldPosition=" + fieldPosition +
                ", talent='" + talent + '\'' +
                ", number=" + number +
                ", numberOfGoals=" + numberOfGoals +
                ", numberOfPass=" + numberOfPass +
                '}';
    }
}
