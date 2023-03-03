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
public class Student extends Person {

    Date enrollmentDate;

    public Student() {
    }

    public Student(int personId, String firstName, String lastName, Date enrollmentDate) {
        super(personId, firstName, lastName);
        this.enrollmentDate = enrollmentDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
