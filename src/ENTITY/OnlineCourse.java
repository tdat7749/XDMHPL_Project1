/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author DELL
 */
public class OnlineCourse extends Course {

    private String Url;

    public OnlineCourse() {
    }

    public OnlineCourse(int CourseID, String Url, String Title, int Credits, int DepartmentID) {
        super(CourseID, Title, Credits, DepartmentID);
        this.Url = Url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}
