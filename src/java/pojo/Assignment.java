package pojo;
// Generated Mar 23, 2015 4:20:09 AM by Hibernate Tools 4.3.1



/**
 * Assignment generated by hbm2java
 */
public class Assignment  implements java.io.Serializable {


     private Integer assignmentId;
     private Lab lab;
     private Student student;
     private String name;
     private String url;

    public Assignment() {
    }

    public Assignment(Lab lab, Student student, String name, String url) {
       this.lab = lab;
       this.student = student;
       this.name = name;
       this.url = url;
    }
   
    public Integer getAssignmentId() {
        return this.assignmentId;
    }
    
    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }
    public Lab getLab() {
        return this.lab;
    }
    
    public void setLab(Lab lab) {
        this.lab = lab;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }




}


