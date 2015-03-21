package pojo;
// Generated Mar 21, 2015 7:45:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer groupId;
     private String name;
     private Set courses = new HashSet(0);
     private Set students = new HashSet(0);

    public Groups() {
    }

    public Groups(String name, Set courses, Set students) {
       this.name = name;
       this.courses = courses;
       this.students = students;
    }
    public Groups(String groupName, int courseID, Set<Student> StudentIDs) {
        this.name = groupName;
        this.students = StudentIDs;
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
    public Set getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set courses) {
        this.courses = courses;
    }
    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }




}


