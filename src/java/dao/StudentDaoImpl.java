/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.StudentDto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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

    
    public StudentDto signInStudent(StudentDto studentDto) {
        boolean flag = false;
        Session session= createSession();
        String name=studentDto.getUserName();
        String pass=studentDto.getPassword();
        Student student = new Student(null, studentDto.getUserName(), studentDto.getPassword(),true);
        Query hql=session.createQuery("from Student S where S.userName = :username and S.password= :pass ").setString( "username",name   ).setString("pass", pass);
        Iterator result =hql.list().iterator();
        if(result.hasNext()){
        student = (Student) result.next();
        flag = true;
        }
       // System.out.println(student.getFulName());
        studentDto.setStudentId(student.getStudentId());
        studentDto.setFulName(student.getFulName());
        closeSession(session);
        System.out.println(studentDto.getStudentId());
        if(flag){
           return studentDto;
        }
        else 
            return null;
        
    }
    public ArrayList<Student> getStudentByDepartmentID (int departmentID){
        Session session = createSession();
        ArrayList <Student> students = new ArrayList<>();
        Query hql = session.createQuery("from Student s where s.department.departmentId = :departmentId ");
        hql.setParameter("departmentId", departmentID);
        students =  (ArrayList<Student>) hql.list();
        return students;
    }
}

