/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

/**
 *
 * @author Mostafa_ITI
 */
public class CourseDAOImpl {

    private SessionFactory sessionFactory;

    public CourseDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    public Iterator<Object[]> getCoursesNames() {
        Iterator<Object[]> result;
        Session session = createSession();
        Query hql = session.createQuery("Select co.courseId,co.name from Course co");
        result = hql.list().iterator();
        return result;
    }
   
}
