/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.OnsiteCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Time;

/**
 *
 * @author DELL
 */
public class OnsiteCourseDAL {

    public static ArrayList<OnsiteCourse> getAllOnsiteCourse() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course, onsitecourse WHERE course.CourseID = onsitecourse.CourseID";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<OnsiteCourse> listOnsiteCourse = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nameCourse = rs.getString(2);
            int credits = rs.getInt(3);
            int departmentID = rs.getInt(4);
            String location = rs.getString(6);
            String days = rs.getString(7);
            Time time = rs.getTime(8);

            listOnsiteCourse.add(new OnsiteCourse(id, location, days, time, nameCourse, credits, departmentID));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listOnsiteCourse;
    }

    public static boolean addOnsiteCourse(OnsiteCourse onsiteCourse) throws Exception {
        int candidateId = 0;
        ResultSet rs = null;
        ConnectDAL connect = null;
        PreparedStatement pstm = null;
        connect = new ConnectDAL();
        String query = "INSERT INTO `course` (`CourseID`, `Title`, `Credits`, "
                + "`DepartmentID`) VALUES (NULL, ?, ?, ?)";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onsiteCourse.getTitle().toString());
        pstm.setInt(2, onsiteCourse.getCredits());
        pstm.setInt(3, onsiteCourse.getDepartmentID());
        int rowAffected = pstm.executeUpdate();
        if (rowAffected == 1) {
            // get candidate id
            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                candidateId = rs.getInt(1);
                System.out.println(candidateId);
            }
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();
        connect = new ConnectDAL();
        query = "INSERT INTO onsitecourse (CourseID, Location, Days, Time) VALUES(?, ?, ?, ?)";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, candidateId);
        pstm.setString(2, onsiteCourse.getLocation());
        pstm.setString(3, onsiteCourse.getDays());
        pstm.setString(4, onsiteCourse.getTime().toString());
        if (!pstm.execute()) {
            rs.close();
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean deleteOnsiteCourseByID(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query;

        query = "DELETE FROM onsitecourse WHERE onsitecourse.CourseID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);
        pstm.execute();

        query = "DELETE FROM course WHERE course.CourseID = ?";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean updateOnsiteCourseByID(int id, OnsiteCourse onsiteCourse) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "UPDATE `course` SET `Title` = ?, `Credits` = ?, `DepartmentID` = ? WHERE `course`.`CourseID` = ?";
        PreparedStatement pstm = null;
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onsiteCourse.getTitle());
        pstm.setInt(2, onsiteCourse.getCredits());
        pstm.setInt(3, onsiteCourse.getDepartmentID());
        pstm.setInt(4, id);
        pstm.executeUpdate();

        query = "UPDATE onsitecourse SET `Location` = ?, `Days` = ?, `Time` = ? WHERE onsitecourse.CourseID = ?";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onsiteCourse.getLocation());
        pstm.setString(2, onsiteCourse.getDays());
        pstm.setString(3, onsiteCourse.getTime().toString());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static ArrayList<OnsiteCourse> searchByNameCourse(String keyWordSearch) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course, onsitecourse WHERE course.Title LIKE ? AND course.CourseID = onsitecourse.CourseID";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<OnsiteCourse> listOnsiteCourse = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nameCourse = rs.getString(2);
            int credits = rs.getInt(3);
            int departmentID = rs.getInt(4);
            String location = rs.getString(6);
            String days = rs.getString(7);
            Time time = rs.getTime(8);

            listOnsiteCourse.add(new OnsiteCourse(id, location, days, time, nameCourse, credits, departmentID));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listOnsiteCourse;
    }

}
