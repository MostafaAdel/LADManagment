/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Course;
import pojo.Groups;
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
    
    public ArrayList<Student> getStudentByDepartmentID (int groupId , String courseName){
        Session session = createSession();
        Query hql =  session.createQuery("from Groups s where s.groupId = :groupid").setInteger("groupid", groupId);
        List groupList = hql.list();
        //id is unique only 1 element will get back
        Groups group = (Groups) groupList.get(0);
        System.out.println(group.getName());
        Query hql2 =  session.createQuery("from Course s where s.name = :coursename").setString("coursename", courseName);
        List courseList = hql2.list();
        //id is unique only 1 element will get back
        Course course = (Course) courseList.get(0);
        System.out.println(course.getName());
        
        
        ArrayList <Student> students = new ArrayList<>();
//        Query hql = session.createQuery("from Student s where s.department.departmentId = :departmentId ");
//        hql.setParameter("departmentId", departmentID);
//        students =  (ArrayList<Student>) hql.list();
//        
        closeSession(session);
        return students;
    }
}
