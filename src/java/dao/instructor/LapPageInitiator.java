/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Course;
import pojo.CourseHasGroups;
import pojo.Groups;
import pojo.Lab;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Hossam
 */
public class LapPageInitiator {
    
    
    
     private SessionFactory sessionFactory;

    public LapPageInitiator() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }
    
    public ArrayList<Lab> getLabsOfCourseGroup (int groupId , String courseName){
        Session session = createSession();
        Query hql =  session.createQuery("from Groups s where s.groupId = :groupid").setInteger("groupid", groupId);
        List groupList = hql.list();
        //id is unique only 1 element will get back
        Groups group = (Groups) groupList.get(0);
//        System.out.println(group.getName());
        Query hql2 =  session.createQuery("from Course s where s.name = :coursename").setString("coursename", courseName);
        List courseList = hql2.list();
        //id is unique only 1 element will get back
        Course course = (Course) courseList.get(0);
//        System.out.println(course.getName());
        
        ArrayList<Lab> labsList = new ArrayList<>();
        
        Query hql3 = session.createQuery("from CourseHasGroups chg where chg.course = :course and chg.groups = :groups").setParameter("course", course).setParameter("groups", group);
        List courseHasGroupsList = hql3.list();
        for(Object chg : courseHasGroupsList){
            CourseHasGroups chgInstance = (CourseHasGroups)chg;
            Set labSet=chgInstance.getLabs();
            for(Object l : labSet){
                labsList.add((Lab)l);
//                System.out.println(((Lab)l).getName());
            }
        }
          
        closeSession(session);
        return labsList;
    }

    public ArrayList<Student> getStudentsOfGroup(int groupId) {
        Session session = createSession();
        Query hql =  session.createQuery("from Groups s where s.groupId = :groupid").setInteger("groupid", groupId);
        List groupList = hql.list();
        //id is unique only 1 element will get back
        Groups group = (Groups) groupList.get(0);
        
        ArrayList<Student> studentsList = new ArrayList<>();
        Set studentsSet = group.getStudents();
        
        for(Object studetObj : studentsSet){
            studentsList.add((Student)studetObj);
        }
        closeSession(session);
        return studentsList;
    }
}
