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
public class LabDaoImpl implements LabDao{

    @Override
    public void closeLab(LabDto lab) {
        System.out.println("in close lab");
    }

    @Override
    public void enableUpload(LabDto lab) {
        System.out.println("in enable upload");
    }

    @Override
    public void shift(LabDto shiftFromLab, LabDto shiftToLab) {
        System.out.println("in shift");
    }

    @Override
    public ArrayList<LabDto> getNextFiveLabs(LabDto currentLab) {
        System.out.println("in get next five labs");
        return null;
    }

    @Override
    public void notifyDelivery(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify delivery");
    }

    @Override
    public void notifyAssistance(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify assistance");
    }
    
}
