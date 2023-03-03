/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import ENTITY.Lecture;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class LectureDAL {

    // Get list lecture
    public static ArrayList<Lecture> getAllLecture() throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM person WHERE person.HireDate";
        PreparedStatement stmt = connect.getConnect().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Lecture> listLecture = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date hireDate = rs.getDate(4);
            Lecture lecture = new Lecture(id, firstName, lastName, hireDate);
            listLecture.add(lecture);
        }
        rs.close();
        stmt.close();
        connect.getConnect().close();
        return listLecture;
    }

    // Add lecture
    public static boolean addLecture(Lecture lecture) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "INSERT INTO `person` (`PersonID`, `Firstname`, `Lastname`, "
                + "`HireDate`, `EnrollmentDate`) VALUES (NULL, ?, ?, ?, NULL)";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, lecture.getFirstName().toString());
        pstm.setString(2, lecture.getLastName().toString());
        pstm.setString(3, lecture.getHireDate().toString());

        // lệnh pstm.execute() thực thi truy vấn thành công trả về giá trị false
        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // delete lecture
    public static boolean deleteLectureById(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "DELETE FROM person WHERE person.personID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // update lecture
    public static boolean updateLectureByID(int id, Lecture lec) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "UPDATE `person` SET `Firstname` = ?, `Lastname` = ?, `HireDate` = ? WHERE `person`.`personID` = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, lec.getFirstName().toString());
        pstm.setString(2, lec.getLastName().toString());
        pstm.setString(3, lec.getHireDate().toString());
        pstm.setInt(4, id);

        if (!pstm.execute()) {
            pstm.close();
            connect.getConnect().close();
            return true;
        }
        return false;
    }

    // search lecture
    public static ArrayList<Lecture> searchByName(String keyWordSearch) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM person WHERE (Lastname LIKE ? OR Firstname LIKE ?) AND person.HireDate";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, "%" + keyWordSearch + "%");
        pstm.setString(2, "%" + keyWordSearch + "%");

        ResultSet rs = pstm.executeQuery();
        ArrayList<Lecture> listLecture = new ArrayList();
        while (rs.next()) {
            int id = rs.getInt(1);
            String firstName = rs.getString(3);
            String lastName = rs.getString(2);
            Date hireDate = rs.getDate(4);
            listLecture.add(new Lecture(id, firstName, lastName, hireDate));
        }
        rs.close();
        pstm.close();
        connect.getConnect().close();

        return listLecture;
    }

    public static String getNameLectureByID(int id) throws Exception {
        ConnectDAL connect = new ConnectDAL();
        String query = "SELECT * FROM person WHERE person.HireDate AND PersonID = ?";
        PreparedStatement pstm = connect.getConnect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            String str = rs.getString("Firstname") + " " + rs.getString("Lastname");
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
