
package dao.instructor;

import dto.instructor.GroupDto;
import dto.instructor.LabDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.CourseHasGroups;
import pojo.Student;
import pojo.Groups;
import pojo.Lab;
import utility.HibernateUtil;

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
    
    
    
    public ArrayList<LabDto> getLabsOfCourse(String courseName,String groupName){
        Session session= createSession();
        
        
        Query getLabsInCertainCourseQuery = session.createQuery("select courseHasGroupses from Course c where c.name = :course");
        getLabsInCertainCourseQuery = getLabsInCertainCourseQuery.setString("course", courseName);
        Iterator result =getLabsInCertainCourseQuery.list().iterator();
        closeSession(session);
        ArrayList<CourseHasGroups> courseHasGroups = new ArrayList<>();
        
        while(result.hasNext()){
            courseHasGroups.add((CourseHasGroups)result.next());
        }
        
        ArrayList<LabDto> labs = new ArrayList<>();
        for(CourseHasGroups chg : courseHasGroups){
            Iterator labsIterator =  chg.getLabs().iterator();
            while(labsIterator.hasNext()){
                labs.add((LabDto)labsIterator.next());
            }
        }
        return labs;
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
//        Groups group = lab.getCourse().getGroups();
//        GroupDto groupDto = new GroupDto(group.getGroupId(), group.getName());
//        InstructorGroups.add(groupDto);
       }
     return InstructorGroups;
     }
}
