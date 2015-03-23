/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CourseDTO;
import dto.GroupDTO;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Course;
import pojo.Groups;
import pojo.Student;
import utility.HibernateUtil;

/**
 *
 * @author Mostafa_ITI
 */
public class GroupDAOImpl {

    private SessionFactory sessionFactory;

    public GroupDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }
//////////////////////////////////////////////////////////////
//////////keyword////////////tobechanged/////////////////////
    /////////////////////////////////////////////////////////

    /**
     * add by Mostafa initialize a deactivated Group without data
     * @param activated boolean
     * @param name String
     * @return void
     */
    public void createGroup(String name, boolean activated) {
        Session session = createSession();

        Groups groups = new Groups(name, activated);
        session.beginTransaction();
        session.save(groups);
        session.getTransaction().commit();
        session.close();
        System.out.println("inserted ya prince");
    }

   /* public static void main(String[] args) {
        GroupDAOImpl aOImpl = new GroupDAOImpl();
        aOImpl.createGroup("firstGoup", false);
    }*/
}
