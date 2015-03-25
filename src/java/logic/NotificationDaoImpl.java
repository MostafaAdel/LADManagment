package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pojo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utility.HibernateUtil;

/**
 *
 * @author HP
 */
public class NotificationDaoImpl {
    
    private SessionFactory sessionFactory;
    
    public NotificationDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Session createSession() {
        return sessionFactory.openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }
    
    public String notifyDelivery(int studentID) {
        
        Session session = createSession();
        session.beginTransaction();
        Student st = (Student) (session.createQuery("from Student s where s.id= :idStudent").setInteger("idStudent", studentID)).uniqueResult();
        
        String notifyDelivery = st.getNotifyDelivery();
        st.setNotifyDelivery(null);
        session.saveOrUpdate(st);
        session.getTransaction().commit();
        System.out.println("Creation Transaction Done");
        
        closeSession(session);
        
        return notifyDelivery;
        
    }
    
    public String notifyAssistance(int studentID) {
        
        Session session = createSession();
        session.beginTransaction();
        Student st = (Student) (session.createQuery("from Student s where s.id= :idStudent").setInteger("idStudent", studentID)).uniqueResult();
        
        String notifyAssistant = st.getNotifyAssistant();
        st.setNotifyAssistant(null);
        session.saveOrUpdate(st);
        session.getTransaction().commit();
        System.out.println("Creation Transaction Done");
        
        closeSession(session);
        
        return notifyAssistant;
    }
    
}
