/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

/**
 *
 * @author Al-Jazayeerly
 */
public class AssignmentDaoImpl implements AssignmentDao{
    
    private SessionFactory sessionFactory;

    public AssignmentDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    private Session createSession(){
        return sessionFactory.openSession();
    }
    private void closeSession(Session session){
        session.close();
    }
}
