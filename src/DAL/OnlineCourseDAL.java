/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.OnlineCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class OnlineCourseDAL {

    public static ArrayList<OnlineCourse> getAllOnlineCourse() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course, onlinecourse WHERE course.CourseID = onlineCourse.CourseID";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<OnlineCourse> listOnlineCourse = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String courseTitle = rs.getString(2);
            int credits = rs.getInt(3);
            int DepartmentID = rs.getInt(4);
            String url = rs.getString(6);
            listOnlineCourse.add(new OnlineCourse(id, url, courseTitle, credits, DepartmentID));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listOnlineCourse;
    }

    public static boolean addOnlineCourse(OnlineCourse onlineCourse) throws Exception {
        int candidateId = 0;
        ResultSet rs = null;
        ConnectDAL connect = new ConnectDAL();
        String query = "INSERT INTO `course` (`CourseID`, `Title`, `Credits`, "
                + "`DepartmentID`) VALUES (NULL, ?, ?, ?)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onlineCourse.getTitle().toString());
        pstm.setInt(2, onlineCourse.getCredits());
        pstm.setInt(3, onlineCourse.getDepartmentID());
        int rowAffected = pstm.executeUpdate();
        if (rowAffected == 1) {
            // get candidate id
            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                candidateId = rs.getInt(1);
                System.out.println(candidateId);
            }
        }
        query = "INSERT INTO onlinecourse (CourseID, url) VALUES(?, ?)";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, candidateId);
        pstm.setString(2, onlineCourse.getUrl());

        if (!pstm.execute()) {
            rs.close();
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static boolean deleteOnlineCourseByID(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query;

        query = "DELETE FROM onlinecourse WHERE onlinecourse.CourseID = ?";
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

    public static boolean updateOnlineCourseByID(int id, OnlineCourse onlineCourse) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "UPDATE `course` SET `Title` = ?, `Credits` = ?, `DepartmentID` = ? WHERE `course`.`CourseID` = ?";
        PreparedStatement pstm = null;
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onlineCourse.getTitle());
        pstm.setInt(2, onlineCourse.getCredits());
        pstm.setInt(3, onlineCourse.getDepartmentID());
        pstm.setInt(4, id);
        pstm.executeUpdate();

        query = "UPDATE onlinecourse SET `url` = ? WHERE onlinecourse.CourseID = ?";
        pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, onlineCourse.getUrl());
        pstm.setInt(2, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    public static ArrayList<OnlineCourse> searchByNameCourse(String keyWordSearch) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course, onlinecourse WHERE course.Title LIKE ? AND course.CourseID = onlinecourse.CourseID";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<OnlineCourse> listOnlineCourse = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String nameCourse = rs.getString(2);
            int credits = rs.getInt(3);
            int departID = rs.getInt(4);
            String url = rs.getString(6);
            listOnlineCourse.add(new OnlineCourse(id, url, nameCourse, credits, departID));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listOnlineCourse;
    }
}
