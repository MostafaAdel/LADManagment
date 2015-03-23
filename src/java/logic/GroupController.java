/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.GroupDAOImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.Course;
import pojo.Student;

/**
 *
 * @author Mostafa_ITI
 */
public class GroupController {

    GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
    /**
     * By: Mostafa
     * initialize a new group with a name
     * @param groupName String
     */
    public void createGroup(String groupName) {
        groupDAOImpl.createGroup(groupName, false);
    }
    
    /**
     * 
     * @return Iterator Object [ id, Name ] of the Group
     */
   public Iterator<Object[]> getAllGroupsNames() {
        Iterator<Object[]> groups = groupDAOImpl.getGroupsNames();
        return groups;
    }
    
    public void updateGroup (){
        
    }

}
