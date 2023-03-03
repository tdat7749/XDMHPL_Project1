/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.OnlineCourseDAL;
import ENTITY.OnlineCourse;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OnlineCourseBLL {

    public static ArrayList<OnlineCourse> getAllOnlineCourse() throws Exception {
        return OnlineCourseDAL.getAllOnlineCourse();
    }

    public static boolean addOnlineCourse(OnlineCourse onlineCourse) throws Exception {
        return OnlineCourseDAL.addOnlineCourse(onlineCourse);
    }

    public static boolean deleteOnlineCourseByID(int id) throws Exception {
        return OnlineCourseDAL.deleteOnlineCourseByID(id);
    }

    public static boolean updateOnlineCourseByID(int id, OnlineCourse onlineCourse) throws Exception {
        return OnlineCourseDAL.updateOnlineCourseByID(id, onlineCourse);
    }

    public static ArrayList<OnlineCourse> searchByNameCourse(String keyWordSearch) throws Exception {
        return OnlineCourseDAL.searchByNameCourse(keyWordSearch);
    }

}
