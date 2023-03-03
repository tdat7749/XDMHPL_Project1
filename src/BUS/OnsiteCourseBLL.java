/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.OnsiteCourseDAL;
import ENTITY.OnsiteCourse;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OnsiteCourseBLL {

    public static ArrayList<OnsiteCourse> getAllOnsiteCourse() throws Exception {
        return OnsiteCourseDAL.getAllOnsiteCourse();
    }

    public static boolean addOnsiteCourse(OnsiteCourse onsiteCourse) throws Exception {
        return OnsiteCourseDAL.addOnsiteCourse(onsiteCourse);
    }

    public static boolean deleteOnsiteCourseByID(int id) throws Exception {
        return OnsiteCourseDAL.deleteOnsiteCourseByID(id);
    }

    public static boolean updateOnsiteCourseByID(int id, OnsiteCourse onsiteCourse) throws Exception {
        return OnsiteCourseDAL.updateOnsiteCourseByID(id, onsiteCourse);
    }

    public static ArrayList<OnsiteCourse> searchByNameCourse(String keyWordSearch) throws Exception {
        return OnsiteCourseDAL.searchByNameCourse(keyWordSearch);
    }
}
