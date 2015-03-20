/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.StudentDao;
import dao.StudentDaoImpl;
import dto.StudentDto;

/**
 *
 * @author Hossam
 */
public class SignInController {
    public boolean isUserExist(StudentDto studentDto){
        StudentDao dao = new StudentDaoImpl();
        studentDto = ((StudentDaoImpl) dao).signInStudent(studentDto);
        if (studentDto != null) {
            return true;
        } else {
            return false;
        }
    }
}
