package pojo;
// Generated Mar 23, 2015 5:28:46 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Department generated by hbm2java
 */
public class Department  implements java.io.Serializable {


     private Integer departmentId;
     private String name;
     private boolean activated;
     private Set students = new HashSet(0);

    public Department() {
    }

	
    public Department(String name, boolean activated) {
        this.name = name;
        this.activated = activated;
    }
    public Department(String name, boolean activated, Set students) {
       this.name = name;
       this.activated = activated;
       this.students = students;
    }
   
    public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActivated() {
        return this.activated;
    }
    
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }




}


