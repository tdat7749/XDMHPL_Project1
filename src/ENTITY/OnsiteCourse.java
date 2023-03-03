/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.sql.Time;

/**
 *
 * @author DELL
 */
public class OnsiteCourse extends Course {

    private String Location;
    private String Days;
    private Time Time;

    public OnsiteCourse() {
    }

    public OnsiteCourse(int CourseID, String Location, String Days, Time Time, String Title, int Credits, int DepartmentID) {
        super(CourseID, Title, Credits, DepartmentID);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

}
