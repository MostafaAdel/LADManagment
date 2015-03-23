/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.InstructorDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;
import dto.InstructorDto;
import dto.StudentDto;

/**
 *
 * @author Hossam
 */
public class SignInController {

    public StudentDto SigninStudent(String userName,String password){
        StudentDto studentDto=new StudentDto(userName, password);
        StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
        studentDto=studentDaoImpl.signInStudent(studentDto);
        return studentDto;
    }
    public InstructorDto SigninInstructor(String userName,String password){
        InstructorDto instructorDto=new InstructorDto(userName, password);
        InstructorDaoImpl instructorDaoImpl=new InstructorDaoImpl();
        instructorDto=instructorDaoImpl.signInInstructor(instructorDto);
        return instructorDto;
    }
}
