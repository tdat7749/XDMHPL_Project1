/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.Course;
import ENTITY.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class CourseDAL {

    public static ArrayList<Course> getAllCourse() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Course> listCourse = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String title = rs.getString(2);
            int credits = rs.getInt(3);
            int departmentID = rs.getInt(4);
            listCourse.add(new Course(id, title, credits, departmentID));
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listCourse;
    }

    public static String getNameCourseByID(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM course WHERE courseID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            String str = rs.getString("Title");
            rs.close();
            pstm.close();
            connect.getConnect().close();
            return str;
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();
        return "";
    }
}
