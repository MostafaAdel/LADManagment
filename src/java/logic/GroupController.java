/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.GroupDAOImpl;
import java.util.ArrayList;
import java.util.Set;
import pojo.Course;
import pojo.Student;

/**
 *
 * @author Mostafa_ITI
 */
public class GroupController {

    GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
//////////////////////////////////////////////////////////////
//////////keyword////////////tobechanged/////////////////////
    /////////////////////////////////////////////////////////
    public void createGroup(String groupName) {
        groupDAOImpl.createGroup(groupName, true);
    }

}
