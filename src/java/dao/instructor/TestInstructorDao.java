/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import dto.instructor.GroupDto;
import dto.instructor.LabDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Groups;
import pojo.Lab;
import utility.HibernateUtil;

/**
 *
 * @author Hossam
 */
public class TestInstructorDao {
    
    private SessionFactory sessionFactory;
    private int instructorId;
    
    public TestInstructorDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
        instructorId = 2;
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }

    
    public ArrayList<LabDto> getLabsOfCourse(String courseName){
        Session session= createSession();
        
        Query getLabsInCertainCourseQuery = session.createQuery("select labs from Course c where c.name = :course");
        getLabsInCertainCourseQuery = getLabsInCertainCourseQuery.setString("course", courseName);
        
        Iterator result =getLabsInCertainCourseQuery.list().iterator();
        closeSession(session);
        ArrayList<LabDto> labsOfCourse = new ArrayList<>();
        if(result.hasNext()){
            labsOfCourse.add((LabDto)result.next());
        }    
        return labsOfCourse;
    }
   public ArrayList<GroupDto> getGroupsOfInstructor(int insId){
     Session session =createSession();
     ArrayList<GroupDto> InstructorGroups=new ArrayList<>(); 
     this.instructorId= insId;
     Query hql=session.createQuery("select labs from Instructor I where I.instructorId = :id").setInteger("id", instructorId);
     Iterator result=hql.list().iterator();
       closeSession(session);
       ArrayList<Lab> labsOfInstructor=new ArrayList<>();
       if(result.hasNext()){
       labsOfInstructor.add((Lab)result.next());
       }
       for(Lab lab:labsOfInstructor){
        Groups group = lab.getCourse().getGroups();
        GroupDto groupDto = new GroupDto(group.getGroupId(), group.getName());
        InstructorGroups.add(groupDto);
       }
     return InstructorGroups;
     }
}
