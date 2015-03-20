package pojo;
// Generated Mar 20, 2015 4:08:21 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Lab generated by hbm2java
 */
public class Lab  implements java.io.Serializable {


     private Integer labId;
     private AssesmentQueue assesmentQueue;
     private Course course;
     private DileveryQueue dileveryQueue;
     private Date startDate;
     private Date endDate;
     private String name;
     private Boolean uploadEnabled;
     private Set dileveryQueues = new HashSet(0);
     private Set assesmentQueues = new HashSet(0);
     private Set instructors = new HashSet(0);
     private Set assignments = new HashSet(0);

    public Lab() {
    }

	
    public Lab(Course course, DileveryQueue dileveryQueue) {
        this.course = course;
        this.dileveryQueue = dileveryQueue;
    }
    public Lab(AssesmentQueue assesmentQueue, Course course, DileveryQueue dileveryQueue, Date startDate, Date endDate, String name, Boolean uploadEnabled, Set dileveryQueues, Set assesmentQueues, Set instructors, Set assignments) {
       this.assesmentQueue = assesmentQueue;
       this.course = course;
       this.dileveryQueue = dileveryQueue;
       this.startDate = startDate;
       this.endDate = endDate;
       this.name = name;
       this.uploadEnabled = uploadEnabled;
       this.dileveryQueues = dileveryQueues;
       this.assesmentQueues = assesmentQueues;
       this.instructors = instructors;
       this.assignments = assignments;
    }
   
    public Integer getLabId() {
        return this.labId;
    }
    
    public void setLabId(Integer labId) {
        this.labId = labId;
    }
    public AssesmentQueue getAssesmentQueue() {
        return this.assesmentQueue;
    }
    
    public void setAssesmentQueue(AssesmentQueue assesmentQueue) {
        this.assesmentQueue = assesmentQueue;
    }
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    public DileveryQueue getDileveryQueue() {
        return this.dileveryQueue;
    }
    
    public void setDileveryQueue(DileveryQueue dileveryQueue) {
        this.dileveryQueue = dileveryQueue;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getUploadEnabled() {
        return this.uploadEnabled;
    }
    
    public void setUploadEnabled(Boolean uploadEnabled) {
        this.uploadEnabled = uploadEnabled;
    }
    public Set getDileveryQueues() {
        return this.dileveryQueues;
    }
    
    public void setDileveryQueues(Set dileveryQueues) {
        this.dileveryQueues = dileveryQueues;
    }
    public Set getAssesmentQueues() {
        return this.assesmentQueues;
    }
    
    public void setAssesmentQueues(Set assesmentQueues) {
        this.assesmentQueues = assesmentQueues;
    }
    public Set getInstructors() {
        return this.instructors;
    }
    
    public void setInstructors(Set instructors) {
        this.instructors = instructors;
    }
    public Set getAssignments() {
        return this.assignments;
    }
    
    public void setAssignments(Set assignments) {
        this.assignments = assignments;
    }




}


