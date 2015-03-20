/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utility;

import dao.AssignmentDao;
import dao.AssignmentDaoImpl;
import dao.StudentDao;
import dao.StudentDaoImpl;

/**
 *
 * @author Hossam
 */
public class DaoProvider {
    /**
     * use this method to return an instance 
     * of the implementation of AssignmentDao
     * 
     * @return AssignmentDaoImplementation
     */
    public static AssignmentDao getAssignmentDaoImpl(){
        return (new AssignmentDaoImpl());
    }
    
    /**
     * use this method to return an instance 
     * of the implementation of AssignmentDao
     * 
     * @return AssignmentDaoImplementation
     */
    public static StudentDao getStudentDaoImpl(){
        return (new StudentDaoImpl());
    }
}
