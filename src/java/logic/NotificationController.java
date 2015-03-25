package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author HP
 */
public class NotificationController {
    
    NotificationDaoImpl notificationDaoImpl = new NotificationDaoImpl();
    
    public String notifyDelivery(int studentID){
        
        return notificationDaoImpl.notifyDelivery(studentID);
    }
    
    public String notifyAssistance(int studentID){
     
        return notificationDaoImpl.notifyAssistance(studentID);
    }
    
}
    

