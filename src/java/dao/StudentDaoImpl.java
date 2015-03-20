/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Dto;
import dto.StudentDTO;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Al-Jazayeerly
 */
public class StudentDaoImpl implements StudentDao{
    
    private SessionFactory sessionFactory;

    public StudentDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }

    
    public StudentDTO signInStudent(Dto dto) {
        Session session= createSession();
        StudentDTO studentDto = (StudentDTO)dto;
        String name=studentDto.getUserName();
        String pass=studentDto.getPassword();
        Student student = new Student(null, studentDto.getUserName(), studentDto.getPassword());
        Query hql=session.createQuery("from Student S where S.userName = :username and S.password= :pass ").setString( "username",name   ).setString("pass", pass);
        Iterator result =hql.list().iterator();
        closeSession(session);
        if(result.hasNext()){
           return studentDto;
        }
        else 
            return null;
        
//        String name=(StudentDTO)dto).
        //Student student= new Student(null, ((StudentDTO)dto)., );
        
           }

    @Override
    public void update(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public List<Dto> get(Dto dto) {
        return null;
    }
    
}
