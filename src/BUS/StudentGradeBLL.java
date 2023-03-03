/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.StudentGradeDAL;
import ENTITY.StudentGrade;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StudentGradeBLL {

    public static ArrayList<StudentGrade> getAllStudentGrade() throws Exception {
        return StudentGradeDAL.getAllStudentGrade();
    }

    public static boolean addStudentGrade(StudentGrade studentGrade) throws Exception {
        return StudentGradeDAL.addStudentGrade(studentGrade);
    }

    public static boolean deleteStudentGradeByID(int id) throws Exception {
        return StudentGradeDAL.deleteStudentGradeByID(id);
    }

    public static boolean updateStudentGradeByID(int id, StudentGrade studentGrade) throws Exception {
        return StudentGradeDAL.updateStudentGradeByID(id, studentGrade);
    }

    public static ArrayList<StudentGrade> searchStudentGradeByNameStudent(String keyWordSearch) throws Exception {
        return StudentGradeDAL.searchStudentGradeByNameStudent(keyWordSearch);
    }
}
