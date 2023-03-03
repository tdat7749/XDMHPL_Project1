/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.DepartmentDAL;
import ENTITY.Department;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DepartmentBLL {

    public static ArrayList<Department> getAllDepartment() throws Exception {
        return DepartmentDAL.getAllDepartment();
    }

    public static boolean addDepartment(Department depart) throws Exception {
        return DepartmentDAL.addDepartment(depart);
    }

    public static boolean deleteDepartmentByID(int id) throws Exception {
        return DepartmentDAL.deleteDepartment(id);
    }

    public static boolean updateDepartmentByID(int id, Department depart) throws Exception {
        return DepartmentDAL.updateDepartmentByID(id, depart);
    }

    public static ArrayList<Department> searchByName(String keyWordSearch) throws Exception {
        return DepartmentDAL.searchByName(keyWordSearch);
    }

    public static String getNameDepartByID(int id) throws Exception {
        return DepartmentDAL.getNameDepartByID(id);
    }

}
