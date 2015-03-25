/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Assignment;
import pojo.Lab;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Al-Jazayeerly
 */
public class AssignmentDaoImpl implements AssignmentDao{
    
    private SessionFactory sessionFactory;

    public AssignmentDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }
    
    public void uploadAssignment(Lab lab,int studetentId,String name,String url){
        
        Session session = createSession();
        Query hql = session.createQuery("from Student s where s.studentId=:studentID").setInteger("studentID", studetentId);
        Student student = (Student) hql.uniqueResult();
        Assignment assig = new Assignment(lab,student,name,url);
        session.getTransaction().begin();
        session.save(assig);
        session.persist(assig);
        session.getTransaction().commit();
        System.out.println("Creation Transaction Done");
       
       
        closeSession(session);
        
        
    }
}
