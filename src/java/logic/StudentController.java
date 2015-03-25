/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.StudentDaoImpl;
import java.util.ArrayList;
import pojo.Student;

/**
 *
 * @author Mostafa_ITI
 */
public class StudentController {
    StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    public ArrayList<Student> getStudentByDepartmentID (int departmentID){
        ArrayList<Student> students = studentDaoImpl.getStudentByDepartmentID(departmentID);
        return students;
    }
}
