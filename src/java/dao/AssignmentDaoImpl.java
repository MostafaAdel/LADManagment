/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AssignmentDto;
import dto.Dto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Assignment;
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
    
    /**
     * 
     * @param dto
     * @return 
     */
    @Override
    
    public List<Dto> get(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param dto 
     */
    @Override
    public void update(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param dto 
     */
    @Override
    public void delete(Dto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * 
     * @param dto 
     */
    @Override
    public void add(Dto dto) {
        Session session=createSession();
        AssignmentDto assignmentDto=(AssignmentDto)dto;
        session.beginTransaction();
     //   Assignment assignment=new Assignment( assignmentDto.getLab(), assignmentDto.getStudent(), assignmentDto.getName(), assignmentDto.getUrl());
     //   session.persist(assignment);
        session.getTransaction().commit();
        closeSession(session);
    }
    
    
}
