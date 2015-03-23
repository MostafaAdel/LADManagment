/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utility.HibernateUtil;

/**
 *
 * @author Hossam
 */
public class NewClass {
    private static SessionFactory sessionFactory;

    static{
        NewClass.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    private static Session createSession(){
        return sessionFactory.openSession();
    }
    private static void closeSession(Session session){
        session.close();
    }
    
    public static void main(String[] args){
         Session session= createSession();
        session.beginTransaction();
        
        
        Department d = new Department("Ewdd", true);
        Groups g = new Groups("ewd", true);
        
        
        Student s1 = new Student(d, "username", "password", true);
        Student s2 = new Student(d, "username2", "password", true);
        Student s3 = new Student(d, "username3", "password", true);
        Student s4 = new Student(d, "username4", "password", true);
        
        Set setOfStudents = new HashSet();
        setOfStudents.add(s1);
        setOfStudents.add(s2);
        setOfStudents.add(s3);
        setOfStudents.add(s4);
        
        d.setStudents(setOfStudents);
        g.setStudents(setOfStudents);
        
        Course c1 = new Course("abc", true);
        Course c2 = new Course("abc1", true);
        Course c3 = new Course("abc2", true);
        Course c4 = new Course("abc3", true);
        
        session.persist(d);
        session.persist(g);
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);
        session.persist(s4);
        session.persist(c1);
        session.persist(c2);
        session.persist(c3);
        session.persist(c4);
        
        
        CourseHasGroupsId  chgid1 = new CourseHasGroupsId(c1.getCourseId(), g.getGroupId());
        CourseHasGroupsId  chgid2 = new CourseHasGroupsId(c2.getCourseId(), g.getGroupId());
        CourseHasGroupsId  chgid3 = new CourseHasGroupsId(c3.getCourseId(), g.getGroupId());
        CourseHasGroupsId  chgid4 = new CourseHasGroupsId(c4.getCourseId(), g.getGroupId());
        
        
        CourseHasGroups chg1 = new CourseHasGroups(chgid1, c1, g);
        CourseHasGroups chg2 = new CourseHasGroups(chgid2, c2, g);
        CourseHasGroups chg3 = new CourseHasGroups(chgid3, c3, g);
        CourseHasGroups chg4 = new CourseHasGroups(chgid4, c4, g);
        
        AssesmentQueue aq1 = new AssesmentQueue(true);
        DileveryQueue dq1 = new DileveryQueue(true);
        AssesmentQueue aq2 = new AssesmentQueue(true);
        DileveryQueue dq2 = new DileveryQueue(true);
        AssesmentQueue aq3 = new AssesmentQueue(true);
        DileveryQueue dq3 = new DileveryQueue(true);
        AssesmentQueue aq4 = new AssesmentQueue(true);
        DileveryQueue dq4 = new DileveryQueue(true);
        
        
        Lab lab1 = new Lab(aq1, chg1, dq1, "lab1" ,  true);
        Lab lab2 = new Lab(aq2, chg1, dq2, "lab2" ,  true);
        Lab lab3 = new Lab(aq3, chg1, dq3, "lab3" ,  true); 
        Lab lab4 = new Lab(aq4, chg1, dq4, "lab4" ,  true); 
        
        session.persist(chg1);
        
        session.persist(lab1);
        lab1.setCourseHasGroups(chg1);
        session.persist(lab1);
        lab2.setCourseHasGroups(chg1);
        session.persist(lab2);
        lab3.setCourseHasGroups(chg1);
        session.persist(lab3);
        lab4.setCourseHasGroups(chg1);
        session.persist(lab4);
        
        aq1.setLab(lab1);
        aq2.setLab(lab2);
        aq3.setLab(lab3);
        aq4.setLab(lab4);
        
        dq1.setLab(lab1);
        dq2.setLab(lab2);
        dq3.setLab(lab3);
        dq4.setLab(lab4);
        
        session.persist(aq1);
        session.persist(aq2);
        session.persist(aq3);
        session.persist(aq4);
        
        session.persist(dq1);
        session.persist(dq2);
        session.persist(dq3);
        session.persist(dq4);
        
         lab1.setAssesmentQueue(aq1);
        
        
        System.out.println(lab2.getLabId());
        
        
        session.getTransaction().commit();
        closeSession(session);
        sessionFactory.close();
    }
}
