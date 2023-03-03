/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.CourseInstructorDAL;
import ENTITY.CourseInstructor;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CourseInstructorBLL {

    public static ArrayList<CourseInstructor> getAllCourseInstructor() throws Exception {
        return CourseInstructorDAL.getAllCourseInstructor();
    }

    public static boolean addCourseInstructor(CourseInstructor courseInstructor) throws Exception {
        return CourseInstructorDAL.addCourseInstructor(courseInstructor);
    }

    public static boolean deleteCourseInstructorByID(int courseID, int personID) throws Exception {
        return CourseInstructorDAL.deleteCourseInstructorByID(courseID, personID);
    }

    public static boolean updateCourseInstructorByID(int courseID, int personID, CourseInstructor courseInstructor) throws Exception {
        return CourseInstructorDAL.updateCourseInstructorByID(courseID, personID, courseInstructor);
    }

    public static ArrayList<CourseInstructor> searchCourseInstructorByNameLecture(String keyWordSearch) throws Exception {
        return CourseInstructorDAL.searchCourseInstructorByNameLecture(keyWordSearch);
    }
}
