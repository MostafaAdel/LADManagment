/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import dao.AssignmentDaoImpl;
import pojo.Lab;
import pojo.Student;

/**
 *
 * @author HP
 */
public class AssignmentController {
    
    AssignmentDaoImpl assignmentDaoImpl = new AssignmentDaoImpl();
    
    public void uploadAssignment(Lab lab, int studentId,String name,String url){
        
        assignmentDaoImpl.uploadAssignment(lab,studentId,name,url);
    }
    
}
