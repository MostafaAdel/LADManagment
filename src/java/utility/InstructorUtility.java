/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Set;

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
    
}
