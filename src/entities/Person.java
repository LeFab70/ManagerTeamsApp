/**
 * La classe abstraite Person représente une personne générique avec des informations personnelles
 * telles que le nom, la date de naissance, le salaire, la nationalité, le poids et la taille.
 *
 * <p>Elle sert de base pour d'autres types de personnes comme les joueurs, coachs, etc.</p>
 *
 * <h2>Fonctionnalités principales :</h2>
 * <ul>
 *     <li>Génération automatique d'un identifiant unique.</li>
 *     <li>Validation de la date de naissance (minimum 18 ans).</li>
 *     <li>Validation du salaire (doit être positif).</li>
 *     <li>Calcul automatique de l'âge.</li>
 * </ul>
 *
 * @author Fabrice & Bruno
 * @version 1.0
 * @since 2025
 */
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

    /**
     * Le salaire doit defini et il doit etre positif
     */
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

    /**
     * Calcule l'âge du joueur à partir de sa date de naissance.
     *
     * @return l'âge du joueur en années.
     */
    private int getAge(){
        return Period.between(this.dateOfBirth,LocalDate.now()).getYears();
    }
    @Override
    public String toString() {
        return "Personne{" +
                " id= "+this.id+
                "  name='" + name + '\'' +
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
