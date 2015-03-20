package pojo;
// Generated Mar 20, 2015 1:53:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Instructor generated by hbm2java
 */
public class Instructor  implements java.io.Serializable {


     private int instructorId;
     private String fulName;
     private int userName;
     private String password;
     private Set labs = new HashSet(0);

    public Instructor() {
    }

	
    public Instructor(int instructorId, int userName, String password) {
        this.instructorId = instructorId;
        this.userName = userName;
        this.password = password;
    }
    public Instructor(int instructorId, String fulName, int userName, String password, Set labs) {
       this.instructorId = instructorId;
       this.fulName = fulName;
       this.userName = userName;
       this.password = password;
       this.labs = labs;
    }
   
    public int getInstructorId() {
        return this.instructorId;
    }
    
    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }
    public String getFulName() {
        return this.fulName;
    }
    
    public void setFulName(String fulName) {
        this.fulName = fulName;
    }
    public int getUserName() {
        return this.userName;
    }
    
    public void setUserName(int userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


