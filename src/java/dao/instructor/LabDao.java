/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.util.ArrayList;

/**
 *
 * @author Hossam
 */
public interface LabDao {
    /**
     * use this method to close an opened lab
     * 
     * @param lab lab to be closed
     */
    public void closeLab(int b);
    
    /**
     * use this method to enable upload of certain lab
     * 
     * @param lab lab to enable its update
     */
    public void enableUpload(int labId);
    
    /**
     * shift queues from a lab to another
     * 
     * @param shiftFromLab lab to shift queues from
     * @param shiftToLab   lab to shift queues to 
     */
    public void shift(int runnLabId,int shiftLabId);
    
    /**
     * return the next five labs in this group after the current one
     * 
     * @param currentLab current lab to search with its data
     * @return the next five labs after current one
     */
    public ArrayList<LabDto> getNextFiveLabs(LabDto currentLab);
    
    /**
     * update the selectedStudent record to add notification 
     * for delivery with the name of the instructor
     * 
     * @param selectedStudent
     * @param instructorId 
     */
    public void notifyDelivery(int studentId,int instructorId,int labId);
    
    /**
     * update the selectedStudent record to add notification 
     * for assistance with the name of the instructor
     * 
     * @param selectedStudent
     * @param instructorId 
     */
    public void notifyAssistance(int studentId,int instructorId);
}
