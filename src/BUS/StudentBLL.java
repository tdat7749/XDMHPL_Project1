/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.StudentDAL;
import ENTITY.Student;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StudentBLL {

    public static ArrayList<Student> getAllStudent() throws Exception {
        return StudentDAL.getAllStudent();
    }

    public static boolean addStudent(Student student) throws Exception {
        return StudentDAL.addStudent(student);
    }

    public static boolean deleteStudentById(int id) throws Exception {
        return StudentDAL.deleteStudentById(id);
    }

    public static boolean updateStudentByID(int id, Student student) throws Exception {
        return StudentDAL.updateStudentByID(id, student);
    }

    public static ArrayList<Student> searchByName(String keyWordSearch) throws Exception {
        return StudentDAL.searchByName(keyWordSearch);
    }

    public static String getNameStudentByID(int id) throws Exception {
        return StudentDAL.getNameStudentByID(id);
    }
}
