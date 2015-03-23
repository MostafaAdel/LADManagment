/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.instructor;

import dao.instructor.TestInstructorDao;
import dto.instructor.CourseDto;
import dto.instructor.GroupDto;
import java.util.ArrayList;

/**
 *
 * @author azza
 */
public class InstructorMianPageController {
    TestInstructorDao insDao=new TestInstructorDao();
    
    public ArrayList<GroupDto> getInstructorGroups(int insId){
     return insDao.getGroupsOfInstructor(insId);
    } 
   
    public ArrayList<CourseDto> getCoursesOfGroup(int insId){
        return insDao.getCoursesOfGroups(insId);
   }
}
