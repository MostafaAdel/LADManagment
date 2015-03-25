/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import dto.instructor.GroupDto;
import java.util.ArrayList;
import java.util.Set;
import pojo.Groups;

/**
 *
 * @author Hossam
 */
public class InstructorUtility {
    public static ArrayList<Object> fromSetToArrayList(Set Objects){
        ArrayList<Object> MyList = new ArrayList<>();
        for(Object obj : Objects){
            MyList.add(obj);
        }
        return MyList;
    }
 
    
    public static boolean checkExistInGroup(ArrayList<GroupDto> list, GroupDto obj){
        for(GroupDto object : list){
            if(object.getName().equals(obj.getName()))
                return true;
        }
        return false;
    }
}
