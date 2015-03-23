package pojo;
// Generated Mar 23, 2015 5:28:46 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CourseHasGroups generated by hbm2java
 */
public class CourseHasGroups  implements java.io.Serializable {


     private CourseHasGroupsId id;
     private Course course;
     private Groups groups;
     private String dummy;
     private Set labs = new HashSet(0);

    public CourseHasGroups() {
    }

	
    public CourseHasGroups(CourseHasGroupsId id, Course course, Groups groups) {
        this.id = id;
        this.course = course;
        this.groups = groups;
    }
    public CourseHasGroups(CourseHasGroupsId id, Course course, Groups groups, String dummy, Set labs) {
       this.id = id;
       this.course = course;
       this.groups = groups;
       this.dummy = dummy;
       this.labs = labs;
    }
   
    public CourseHasGroupsId getId() {
        return this.id;
    }
    
    public void setId(CourseHasGroupsId id) {
        this.id = id;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public Groups getGroups() {
        return this.groups;
    }
    
    public void setGroups(Groups groups) {
        this.groups = groups;
    }
    public String getDummy() {
        return this.dummy;
    }
    
    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


