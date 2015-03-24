package pojo;
// Generated Mar 23, 2015 7:12:27 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer studentId;
     private Department department;
     private String fulName;
     private String userName;
     private String password;
     private boolean activated;
     private Set groupses = new HashSet(0);
     private Set dileveryQueues = new HashSet(0);
     private Set requestAssesments = new HashSet(0);
     private Set assignments = new HashSet(0);

    public Student() {
    }

	
    public Student(Department department, String userName, String password, boolean activated) {
        this.department = department;
        this.userName = userName;
        this.password = password;
        this.activated = activated;
    }
    public Student(Department department, String fulName, String userName, String password, boolean activated, Set groupses, Set dileveryQueues, Set requestAssesments, Set assignments) {
       this.department = department;
       this.fulName = fulName;
       this.userName = userName;
       this.password = password;
       this.activated = activated;
       this.groupses = groupses;
       this.dileveryQueues = dileveryQueues;
       this.requestAssesments = requestAssesments;
       this.assignments = assignments;
    }
   
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getFulName() {
        return this.fulName;
    }
    
    public void setFulName(String fulName) {
        this.fulName = fulName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActivated() {
        return this.activated;
    }
    
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public Set getGroupses() {
        return this.groupses;
    }
    
    public void setGroupses(Set groupses) {
        this.groupses = groupses;
    }
    public Set getDileveryQueues() {
        return this.dileveryQueues;
    }
    
    public void setDileveryQueues(Set dileveryQueues) {
        this.dileveryQueues = dileveryQueues;
    }
    public Set getRequestAssesments() {
        return this.requestAssesments;
    }
    
    public void setRequestAssesments(Set requestAssesments) {
        this.requestAssesments = requestAssesments;
    }
    public Set getAssignments() {
        return this.assignments;
    }
    
    public void setAssignments(Set assignments) {
        this.assignments = assignments;
    }




}


