/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.CourseInstructor;
import ENTITY.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CourseInstructorDAL {

    public static ArrayList<CourseInstructor> getAllCourseInstructor() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM courseinstructor";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<CourseInstructor> listCourseInstructor = new ArrayList();
        while (rs.next()) {
            int courseID = rs.getInt(1);
            int personID = rs.getInt(2);
            listCourseInstructor.add(new CourseInstructor(courseID, personID));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listCourseInstructor;
    }

    public static boolean addCourseInstructor(CourseInstructor courseInstructor) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "INSERT INTO `courseinstructor` (`CourseID`, `PersonID`) VALUES (?, ?)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, courseInstructor.getCourseID());
        pstm.setInt(2, courseInstructor.getPersonID());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean deleteCourseInstructorByID(int courseID, int personID) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "DELETE FROM courseinstructor WHERE courseinstructor.CourseID = ? AND courseinstructor.PersonID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, courseID);
        pstm.setInt(2, personID);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean updateCourseInstructorByID(int courseID, int personID, CourseInstructor courseInstructor) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "UPDATE `courseinstructor` SET `CourseID` = ?, `personID` = ? WHERE `courseinstructor`.`courseID` = ? "
                + "AND `courseinstructor`.`personID` = ?";
        
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, courseInstructor.getCourseID());
        pstm.setInt(2, courseInstructor.getPersonID());
        pstm.setDouble(3, courseID);
        pstm.setInt(4, personID);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static ArrayList<CourseInstructor> searchCourseInstructorByNameLecture(String keyWordSearch) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM courseinstructor, person WHERE (courseinstructor.PersonID = person.PersonID) "
                + "AND (person.Lastname LIKE ? OR person.Firstname LIKE ?)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");
        pstm.setString(2, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<CourseInstructor> listCourseInstructor = new ArrayList();
        while (rs.next()) {
            int courseID = rs.getInt(1);
            int personID = rs.getInt(2);
            listCourseInstructor.add(new CourseInstructor(courseID, personID));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listCourseInstructor;
    }
}
