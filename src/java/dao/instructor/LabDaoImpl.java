
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

        System.out.println("Name: " + lab.getName());
        System.out.println("Assesment " + lab.getAssesmentQueue().getAssesmentQueueId());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.instructor;

import dao.AssessmentQueueDAO;
import dao.DeliveryQueueDAO;
import dto.instructor.AssesmentQueueDto;
import dto.instructor.DileveryQueueDto;
import dto.instructor.LabDto;
import dto.instructor.StudentDto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.bytecode.Descriptor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.AssesmentQueue;
import pojo.Assignment;
import pojo.DileveryQueue;
import pojo.Groups;
import pojo.Instructor;
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

    public ArrayList<Student> getStudentsOfGroup(int groupId) {
        Session session = createSession();
        Query hql = session.createQuery("from Groups s where s.groupId = :groupid").setInteger("groupid", groupId);
        List groupList = hql.list();
        //id is unique only 1 element will get back
        Groups group = (Groups) groupList.get(0);

        ArrayList<Student> studentsList = new ArrayList<>();
        Set studentsSet = group.getStudents();

        for (Object studetObj : studentsSet) {
            studentsList.add((Student) studetObj);
        }
        closeSession(session);
        return studentsList;
    }

    @Override
    public void closeLab(int labId) {
        System.out.println("in close lab in lab dao impl");
        Session session = createSession();
        session.beginTransaction();
        Query hql = session.createQuery("from Lab L where L.labId = :labid").setInteger("labid", labId);
        Lab lab = (Lab) hql.uniqueResult();
        lab.setEndDate(new Date());

        session.saveOrUpdate(lab);
        session.getTransaction().commit();
        System.out.println(lab.getEndDate());
        closeSession(session);
    }

    @Override
    public void enableUpload(int labId) {
        Session session = createSession();
        session.beginTransaction();
        Query hql = session.createQuery("from Lab L where L.labId = :labid").setInteger("labid", labId);
        Lab lab = (Lab) hql.uniqueResult();
        lab.setUploadEnabled(true);
        System.out.println(lab.getUploadEnabled());
        session.saveOrUpdate(lab);
        session.getTransaction().commit();
        closeSession(session);
    }

    @Override
    public void shift(int runningLabId,int shifitingLabId) {
        Session session=createSession();
        session.beginTransaction();
        Lab runLAB=(Lab)session.createQuery("from Lab l where l.labId=:labID").setInteger("labID", runningLabId).uniqueResult();
       AssesmentQueue sq=(AssesmentQueue) runLAB.getAssesmentQueue();
       DileveryQueue dQ=(DileveryQueue) runLAB.getDileveryQueue();
       Lab shiftLAB=(Lab)session.createQuery("from Lab l where l.labId=:labID").setInteger("labID", shifitingLabId).uniqueResult();
       shiftLAB.setAssesmentQueue(sq);
       shiftLAB.setDileveryQueue(dQ);
       
       Set lsq = sq.getLabs();
       lsq.add(shiftLAB);
       sq.setLabs(lsq);
       
       Set ldq = dQ.getLabs();
       ldq.add(shiftLAB);
       dQ.setLabs(ldq);
       
        session.saveOrUpdate(shiftLAB);
        session.saveOrUpdate(dQ);
        session.saveOrUpdate(sq);
        
        session.getTransaction().commit();
        closeSession(session);
    }

    @Override
    public ArrayList<LabDto> getNextFiveLabs(LabDto currentLab) {
        System.out.println("in get next five labs");
        return null;
    }

    @Override
    public void notifyDelivery(int studentId, int instructorId,int labId) {
        Session session = createSession();
        session.beginTransaction();
        Query shql = session.createQuery("from Student s where s.studentId= :stuId").setInteger("stuId", studentId);
        Query ihql = session.createQuery("from Instructor I where I.instructorId= :insId").setInteger("insId", instructorId);
        Student stu = (Student) shql.uniqueResult();
        Instructor ins = (Instructor) ihql.uniqueResult();
        stu.setNotifyDelivery(ins.getUserName());
        session.saveOrUpdate(stu);
        session.getTransaction().commit();
        DeliveryQueueDAO devQ=new DeliveryQueueDAO();
        devQ.cancelDeliveryRequest(labId, studentId);
        closeSession(session);
    }

    @Override
    public void notifyAssistance(int studentId, int instructorId) {
        Session session = createSession();
        session.beginTransaction();
        System.out.println("im in 2");
        Query shql = session.createQuery("from Student s where s.studentId= :stuId").setInteger("stuId", studentId);
        Query ihql = session.createQuery("from Instructor I where I.instructorId= :insId").setInteger("insId", instructorId);
        Student stu = (Student) shql.uniqueResult();
        Instructor ins = (Instructor) ihql.uniqueResult();
        stu.setNotifyAssistant(ins.getUserName());
        System.out.println("im in 3");
        session.saveOrUpdate(stu);
        session.getTransaction().commit();
       AssessmentQueueDAO assDaq=new AssessmentQueueDAO();
       assDaq.DeleteAssesmnetRequest(studentId);
        closeSession(session);
    }

    public ArrayList<Assignment> getAssingnemt(int labId, int stuId) {
        Session session = createSession();
        Query hql = session.createQuery("from Assignment a where a.lab.labId= :iabId and a.student.studentId= :stuId").setInteger("iabId", labId).setInteger("stuId", stuId);
        Iterator file = hql.list().iterator();
        ArrayList<Assignment> assignments=new ArrayList<>();
        while (file.hasNext()) {
            Assignment a = (Assignment) file.next();
            String fileName = a.getName();
            String fileUrl = a.getUrl();
            assignments.add(a);
            System.out.println(fileName);
            System.out.println(fileUrl);
        }
        return assignments;
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
        // Lab lab = daoImpl.getActiveLab("username");
        daoImpl.getAssingnemt(3, 1);
       // System.out.println("Name: "+lab.getName());
        // System.out.println("Assesment " + lab.getAssesmentQueue().getAssesmentQueueId());
    }
}
