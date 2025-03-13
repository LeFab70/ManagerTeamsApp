package entities;

import exceptions.DateOfBirthException;
import exceptions.SalaryException;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person {
    private static final AtomicInteger count= new AtomicInteger(1);
    private  int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private double salary;
    private String nationality;
    private double weight;
    private double height;

    public Person(final String name, final  String surname, final  LocalDate dateOfBirth, final double salary, final String nationality, final double weight, final double height) throws DateOfBirthException, SalaryException {
        if (dateOfBirth == null) {
            throw new DateOfBirthException("La date de naissance ne peut pas être nulle.");
        }

        this.dateOfBirth = dateOfBirth;
        this.id=count.getAndIncrement();
        this.name = name;
        this.surname = surname;
        //setDateOfBirth(dateOfBirth);
        this.dateOfBirth=dateOfBirth;
        setSalary(salary);
        this.nationality = nationality;
        this.weight = weight;
        this.height = height;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws DateOfBirthException {

        if (dateOfBirth == null) {
            throw new DateOfBirthException("La date de naissance ne peut pas être nulle.");
        }


        if (getAge()<=18)
            throw new DateOfBirthException("La date de naissance doit correspondre à au moins de 18 ans");
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws SalaryException {
        if(this.salary<0)
            throw new SalaryException("Le salaire défini doit être supérieur à zero");
        this.salary = salary;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private int getAge(){
        return Period.between(this.dateOfBirth,LocalDate.now()).getYears();
    }
    @Override
    public String toString() {
        return "Personne{" +
                "id= "+this.id+
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                "( Age= "+ getAge()+" Ans) "+
                ", salary=" + salary +
                ", nationality='" + nationality + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
