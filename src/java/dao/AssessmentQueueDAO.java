/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.instructor.LabDaoImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.AssesmentQueue;
import pojo.Lab;
import pojo.RequestAssesment;
import pojo.RequestAssesmentId;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Mostafa_ITI
 */
public class AssessmentQueueDAO {

    private SessionFactory sessionFactory;

    public AssessmentQueueDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    public ArrayList<Student> getStudentsOnAssessmentQueue(String studentUserName) {

        ArrayList<Student> students = new ArrayList<>();
        LabDaoImpl labDaoImpl = new LabDaoImpl();
        AssesmentQueue assesmentQueue = labDaoImpl.getActiveLab(studentUserName).getAssesmentQueue();
        Iterator<RequestAssesment> assesments = (Iterator<RequestAssesment>) assesmentQueue.getRequestAssesments().iterator();
//        System.out.println("Assesment Requests: " + assesments.);
        RequestAssesment tempRequestAssesment = null;
        while (assesments.hasNext()) {
            tempRequestAssesment = assesments.next();
            if (tempRequestAssesment.isExistInQueue()) {

                students.add(tempRequestAssesment.getStudent());
            }
        }

        //    System.out.println(((RequestAssesment)(assesmentQueue.getRequestAssesments().iterator().next())).getStudent().getUserName());
        return students;
    }

    public void addRequestAssesment(String labName, int studentId) {

        Session session = createSession();
        session.beginTransaction();
        Query hql = session.createQuery("from Lab l where l.name=:name").setString("name", labName);
        Lab lab = (Lab) hql.uniqueResult();
        //gbna el lab
        AssesmentQueue assesmentQueue = lab.getAssesmentQueue();
        //gbna el assesmentQueue(SSSSS)

        //gbna set of request assesments
        Query hql2 = session.createQuery("from Student s where s.studentId=:studentID").setInteger("studentID", studentId);
        Student student = (Student) hql2.uniqueResult();
        //gbna el student

        RequestAssesmentId requestAssesmentId = new RequestAssesmentId(studentId, assesmentQueue.getAssesmentQueueId());
        RequestAssesment requestAssesment = new RequestAssesment(requestAssesmentId, assesmentQueue, student, 1, true);

        Set requestAssestments = assesmentQueue.getRequestAssesments();
        Set<RequestAssesment> setRequestAssesments = (Set<RequestAssesment>) lab.getAssesmentQueue().getRequestAssesments();
        Iterator<RequestAssesment> iteratorRA = setRequestAssesments.iterator();
        RequestAssesment exsitRquest = null;
        boolean found = false;
        while (iteratorRA.hasNext() && !found) {
            exsitRquest = iteratorRA.next();
            if (exsitRquest.getStudent().getStudentId() == studentId) {
                found = true;
            }
        }

        requestAssestments.add(requestAssesment);
        assesmentQueue.setRequestAssesments(requestAssestments);

        Set ra = student.getRequestAssesments();
        ra.add(requestAssesment);
        student.setRequestAssesments(ra);
        if (found) {
            int number_of_request = exsitRquest.getNumberOfRequests();
            exsitRquest.setNumberOfRequests(++number_of_request);
            exsitRquest.setExistInQueue(true);
            session.saveOrUpdate(exsitRquest);
        } else {
            session.persist(requestAssesment);
        }
        session.saveOrUpdate(assesmentQueue);
        session.saveOrUpdate(student);

        session.getTransaction().commit();
        session.close();
    }

    public void DeleteAssesmnetRequest(String labName, int studentId) {
        Session session = createSession();
        session.beginTransaction();

        //get student 
        Query hql = session.createQuery("from Student s where s.studentId=:studentID").setInteger("studentID", studentId);
        Student student = (Student) hql.uniqueResult();

        // get Assestment Requst
        Query hql2 = session.createQuery("from  RequestAssesment RA where RA.student=:student").setEntity("student", student);
        RequestAssesment ra = (RequestAssesment) hql2.uniqueResult();
        if (ra != null) {
            boolean existinQueue = ra.isExistInQueue();
            int number_of_request = ra.getNumberOfRequests();
            if (number_of_request > 0 && existinQueue) {
                System.out.println("right case");
                ra.setNumberOfRequests(--number_of_request);
            }
            ra.setExistInQueue(false);
            session.saveOrUpdate(ra);
            session.getTransaction().commit();
        }
        session.close();

    }

    public static void main(String[] args) {
        AssessmentQueueDAO aqdao = new AssessmentQueueDAO();
        // aqdao.addRequestAssesment("lab1", 17);
        aqdao.DeleteAssesmnetRequest("lab1", 17);
//        aqdao.getStudentsOnAssessmentQueue("username");
//        Iterator<Student> iterator = aqdao.getStudentsOnAssessmentQueue("username").iterator();
//        while (iterator.hasNext()) {
//            Student next = iterator.next();
//            System.out.println(next.getUserName());
//
//        }
    }
}
