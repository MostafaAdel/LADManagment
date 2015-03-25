/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.InstructorDto;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;
import pojo.Instructor;

/**
 *
 * @author Al-Jazayeerly
 */
public class InstructorDaoImpl implements  InstructorDao{
      private SessionFactory sessionFactory;

    public InstructorDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }
    
     public InstructorDto signInInstructor(InstructorDto instructorDto) {
        Session session= createSession();
        String name=instructorDto.getUserName();
        String pass=instructorDto.getPassword();
        Instructor instructor = new Instructor(instructorDto.getUserName(), instructorDto.getPassword(),true);
        Query hql=session.createQuery("from Instructor I where I.userName = :username and I.password= :pass ").setString( "username",name   ).setString("pass", pass);
        Iterator result =hql.list().iterator();
        closeSession(session);
        if(result.hasNext()){
            Instructor ins = ((Instructor)result.next());
           return new InstructorDto(ins.getInstructorId()   , ins.getUserName());
        }
        else 
            return null;
        
    }
   
    
}
