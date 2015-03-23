      /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.instructor;

import dao.instructor.LabDao;
import dao.utility.DaoProvider;
import dto.instructor.LabDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import pojo.Course;
import pojo.CourseHasGroups;
import pojo.CourseHasGroupsId;
import pojo.Groups;

/**
 *
 * @author Hossam
 */
public class LabPageController{
    
    private final int instructorId;
    private LabDao labDao;
    
    private ArrayList<LabDto> labsViewdto;

    /**
     * 
     * @param instructorId
     * @param labsViewdto 
     */
    public LabPageController(int instructorId, ArrayList<LabDto> labsViewdto) {
        this.instructorId = instructorId;
        this.labsViewdto = labsViewdto;
        this.labDao = DaoProvider.getLabDaoImpl();
    }

    public int getInstructorId() {
        return instructorId;
    }

    public LabDao getLabDao() {
        return labDao;
    }

    public ArrayList<LabDto> getLabsViewdto() {
        return labsViewdto;
    }

    public void setLabDao(LabDao labDao) {
        this.labDao = labDao;
    }

    public void setLabViewdto(ArrayList<LabDto> labsViewdto) {
        this.labsViewdto = labsViewdto;
    }
    /**
     * return the labViewDto object for the lab with 
     * a specific name
     * 
     * @param labName  to use for getting the labViewDto
     * @return  labViewDto for the lab with this name
     */
    public LabDto getSelectedLabDto(String labName){
        for(LabDto lab:labsViewdto){
            if(lab.getName().equals(labName)){
                return lab;
            }
        }
        return null;
    }
    
    public boolean isLabsFound(){
        if(labsViewdto.size() == 0 || labsViewdto == null)
            return false;
        else
            return true;
    }
    
}
