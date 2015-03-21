/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DepartmentDTO;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

/**
 *
 * @author Mostafa_ITI
 */
public class DepartmentDAOImpl {

    private SessionFactory sessionFactory;

    public DepartmentDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }

    public Iterator<Object[]> getDepartmentNames() {
        Iterator<Object[]> result;
        Session session = createSession();
        Query hql = session.createQuery("Select dept.id,dept.name from Department dept");
        result = hql.list().iterator();
        return result;
    }
}
