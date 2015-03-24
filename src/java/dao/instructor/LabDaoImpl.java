<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import dto.instructor.AssesmentQueueDto;
import dto.instructor.DileveryQueueDto;
import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javassist.bytecode.Descriptor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Lab;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Hossam
 */
public class LabDaoImpl implements LabDao {

    private SessionFactory sessionFactory;

    public LabDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    @Override
    public void closeLab(LabDto lab) {
        System.out.println("in close lab");
    }

    @Override
    public void enableUpload(LabDto lab) {
        System.out.println("in enable upload");
    }

    @Override
    public void shift(LabDto shiftFromLab, LabDto shiftToLab) {
        System.out.println("in shift");
    }

    @Override
    public ArrayList<LabDto> getNextFiveLabs(LabDto currentLab) {
        System.out.println("in get next five labs");
        return null;
    }

    @Override
    public void notifyDelivery(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify delivery");
    }

    @Override
    public void notifyAssistance(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify assistance");
    }

    /**
     *
     */
    /*  public Lab getAllActiveLabs() {
     Session session = createSession();
     Iterator<Lab> lab = null;
     Query hql = session.createQuery("from Lab l where l.activated = 1");
     lab = hql.list().iterator();
     //        session.close();
     return lab;
     }*/
    public Lab getActiveLab(String studentUsername) {
        boolean flag = false;
        Session session = createSession();
        Lab lab = null;
        LabDto labDto = null;
        Iterator<Lab> labIterator = null;
        AssesmentQueueDto assesmentQueue = null;
        DileveryQueueDto dileveryQueue = null;
        Iterator<Student> studentIterator = null;
        Query hql = session.createQuery("from Lab l where l.activated = 1 ");
        labIterator = hql.list().iterator();
        
        while (labIterator.hasNext() && !flag) {
            lab = labIterator.next();
            studentIterator = lab.getCourseHasGroups().getGroups().getStudents().iterator();
            while (studentIterator.hasNext()) {
                Student next = studentIterator.next();
                if (studentUsername.equalsIgnoreCase(next.getUserName())) {
                    System.out.println("inside if student");
                    flag = true;
                    break;
                }
            }
            
        }

        if (flag) {
            return lab;
        }
        return null;
    }

    public static void main(String[] args) {
        LabDaoImpl daoImpl = new LabDaoImpl();
        Lab lab = daoImpl.getActiveLab("username");
        
        System.out.println("Name: "+lab.getName());
        System.out.println("Assesment " + lab.getAssesmentQueue().getAssesmentQueueId());
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import dto.instructor.AssesmentQueueDto;
import dto.instructor.DileveryQueueDto;
import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javassist.bytecode.Descriptor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Lab;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Hossam
 */
public class LabDaoImpl implements LabDao {

    private SessionFactory sessionFactory;

    public LabDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    @Override
    public void closeLab(LabDto lab) {
        System.out.println("in close lab");
    }

    @Override
    public void enableUpload(LabDto lab) {
        System.out.println("in enable upload");
    }

    @Override
    public void shift(LabDto shiftFromLab, LabDto shiftToLab) {
        System.out.println("in shift");
    }

    @Override
    public ArrayList<LabDto> getNextFiveLabs(LabDto currentLab) {
        System.out.println("in get next five labs");
        return null;
    }

    @Override
    public void notifyDelivery(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify delivery");
    }

    @Override
    public void notifyAssistance(StudentDto selectedStudent, int instructorId) {
        System.out.println("in notify assistance");
    }

    /**
     *
     */
    /*  public Lab getAllActiveLabs() {
     Session session = createSession();
     Iterator<Lab> lab = null;
     Query hql = session.createQuery("from Lab l where l.activated = 1");
     lab = hql.list().iterator();
     //        session.close();
     return lab;
     }*/
    public Lab getActiveLab(String studentUsername) {
        boolean flag = false;
        Session session = createSession();
        Lab lab = null;
        LabDto labDto = null;
        Iterator<Lab> labIterator = null;
        AssesmentQueueDto assesmentQueue = null;
        DileveryQueueDto dileveryQueue = null;
        Iterator<Student> studentIterator = null;
        Query hql = session.createQuery("from Lab l where l.activated = 1 ");
        labIterator = hql.list().iterator();
        
        while (labIterator.hasNext() && !flag) {
            lab = labIterator.next();
            studentIterator = lab.getCourseHasGroups().getGroups().getStudents().iterator();
            while (studentIterator.hasNext()) {
                Student next = studentIterator.next();
                if (studentUsername.equalsIgnoreCase(next.getUserName())) {
                    System.out.println("inside if student");
                    flag = true;
                    break;
                }
            }
            
        }

        if (flag) {
            return lab;
        }
        return null;
    }

    public static void main(String[] args) {
        LabDaoImpl daoImpl = new LabDaoImpl();
        Lab lab = daoImpl.getActiveLab("username");
        
        System.out.println("Name: "+lab.getName());
        System.out.println("Assesment " + lab.getAssesmentQueue().getAssesmentQueueId());
    }
}
>>>>>>> 47d89df5014cd689881c6673ab374229c08df3d6
