/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.CourseDAL;
import ENTITY.Course;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CourseBLL {

    public static ArrayList<Course> getAllCourse() throws Exception {
        return CourseDAL.getAllCourse();
    }

    public static String getNameCourseByID(int id) throws Exception {
        return CourseDAL.getNameCourseByID(id);
    }
}
