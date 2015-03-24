/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.instructor.LabDaoImpl;
import dto.StudentDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.AssesmentQueue;
import pojo.DileveryQueue;
import pojo.Lab;
import pojo.RequestAssesment;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Mostafa_ITI
 */
public class DeliveryQueueDAO {

    private SessionFactory sessionFactory;

    public DeliveryQueueDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    public ArrayList<Student> getStudentsOnDeliveryQueue(String studentUserName) {

        LabDaoImpl labDaoImpl = new LabDaoImpl();
        ArrayList<Student> studentsArr = new ArrayList<>();
        DileveryQueue deliveryQueue = labDaoImpl.getActiveLab(studentUserName).getDileveryQueue();
        Iterator<Student> students = (Iterator<Student>) deliveryQueue.getStudents().iterator();

        while (students.hasNext()) {

            studentsArr.add(students.next());
        }

        //System.out.println(((RequestAssesment)(assesmentQueue.getRequestAssesments().iterator().next())).getStudent().getUserName());
        return studentsArr;
    }

    public void addRequestDelivery(String labName, int studentId) {

        Session session = createSession();
        session.beginTransaction();
        Query hql = session.createQuery("from Lab l where l.name=:name").setString("name", labName);
        Lab lab = (Lab) hql.uniqueResult();
        DileveryQueue dileveryQueue= lab.getDileveryQueue();
        Set students = dileveryQueue.getStudents();
        Query hql2 = session.createQuery("from Student s where s.studentId=:studentID").setInteger("studentID", studentId);
        Student student = (Student) hql2.uniqueResult();
        students.add(student);
        dileveryQueue.setStudents(students);
        
        Set dilevryQueues = student.getDileveryQueues();
        dilevryQueues.add(dileveryQueue);
        student.setDileveryQueues(dilevryQueues);
        
        session.saveOrUpdate(dileveryQueue);
        session.saveOrUpdate(student);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        DeliveryQueueDAO aqdao = new DeliveryQueueDAO();
        aqdao.addRequestDelivery("lab1", 17);

    }
}
