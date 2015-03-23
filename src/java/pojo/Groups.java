package pojo;
// Generated Mar 23, 2015 5:28:46 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer groupId;
     private String name;
     private boolean activated;
     private Set students = new HashSet(0);
     private Set courseHasGroupses = new HashSet(0);

    public Groups() {
    }

	
    public Groups(String name, boolean activated) {
        this.name = name;
        this.activated = activated;
    }
    public Groups(String name, boolean activated, Set students, Set courseHasGroupses) {
       this.name = name;
       this.activated = activated;
       this.students = students;
       this.courseHasGroupses = courseHasGroupses;
    }
   
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
    public Set getCourseHasGroupses() {
        return this.courseHasGroupses;
    }
    
    public void setCourseHasGroupses(Set courseHasGroupses) {
        this.courseHasGroupses = courseHasGroupses;
    }




}


