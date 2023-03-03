/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StudentGradeDAL {

    public static ArrayList<StudentGrade> getAllStudentGrade() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM studentgrade";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<StudentGrade> listStudentGrade = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            int courseID = rs.getInt(2);
            int studentID = rs.getInt(3);
            double grade = rs.getDouble(4);
            listStudentGrade.add(new StudentGrade(id, courseID, studentID, grade));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listStudentGrade;
    }

    public static boolean addStudentGrade(StudentGrade studentGrade) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "INSERT INTO `studentgrade` (`EnrollmentID`, `CourseID`, `StudentID`, "
                + "`Grade`) VALUES (NULL, ?, ?, ?)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, studentGrade.getCourseID());
        pstm.setInt(2, studentGrade.getStudentID());
        pstm.setDouble(3, studentGrade.getGrade());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean deleteStudentGradeByID(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "DELETE FROM studentgrade WHERE studentgrade.enrollmentID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean updateStudentGradeByID(int id, StudentGrade studentGrade) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "UPDATE `studentgrade` SET `CourseID` = ?, `StudentID` = ?, `Grade` = ? "
                + "WHERE `studentgrade`.`enrollmentID` = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, studentGrade.getCourseID());
        pstm.setInt(2, studentGrade.getStudentID());
        pstm.setDouble(3, studentGrade.getGrade());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static ArrayList<StudentGrade> searchStudentGradeByNameStudent(String keyWordSearch) throws SQLException, Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM studentgrade, person WHERE (studentgrade.StudentID = person.PersonID) "
                + "AND (person.Lastname LIKE ? OR person.Firstname LIKE ?)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");
        pstm.setString(2, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<StudentGrade> listStudentGrade = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            int courseID = rs.getInt(2);
            int studentID = rs.getInt(3);
            double grade = rs.getDouble(4);
            listStudentGrade.add(new StudentGrade(id, courseID, studentID, grade));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listStudentGrade;
    }
}
