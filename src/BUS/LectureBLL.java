/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.LectureDAL;
import ENTITY.Lecture;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LectureBLL {

    public static ArrayList<Lecture> getAllLecture() throws Exception {
        return LectureDAL.getAllLecture();
    }

    public static boolean addLecture(Lecture lecture) throws Exception {
        return LectureDAL.addLecture(lecture);
    }

    public static boolean deleteLectureById(int id) throws Exception {
        return LectureDAL.deleteLectureById(id);
    }

    public static boolean updateLectureByID(int id, Lecture lec) throws Exception {
        return LectureDAL.updateLectureByID(id, lec);
    }

    public static ArrayList<Lecture> searchByName(String keyWordSearch) throws Exception {
        return LectureDAL.searchByName(keyWordSearch);
    }

    public static String getNameLectureByID(int id) throws Exception {
        return LectureDAL.getNameLectureByID(id);
    }
}
