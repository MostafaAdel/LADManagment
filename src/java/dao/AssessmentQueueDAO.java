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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.AssesmentQueue;
import pojo.RequestAssesment;
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

        while (assesments.hasNext()) {

            students.add(assesments.next().getStudent());
        }

        //    System.out.println(((RequestAssesment)(assesmentQueue.getRequestAssesments().iterator().next())).getStudent().getUserName());
        return students;
    }

    public static void main(String[] args) {
        AssessmentQueueDAO aqdao = new AssessmentQueueDAO();
        aqdao.getStudentsOnAssessmentQueue("username");
        Iterator<Student> iterator = aqdao.getStudentsOnAssessmentQueue("username").iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next.getUserName());

        }
    }
}
