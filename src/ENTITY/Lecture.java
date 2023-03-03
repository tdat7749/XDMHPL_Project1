/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Lecture extends Person {

    Date HireDate;

    public Lecture() {

    }

    public Lecture(int personID, String firstName, String lastName, Date HireDate) {
        super(personID, firstName, lastName);
        this.HireDate = HireDate;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
