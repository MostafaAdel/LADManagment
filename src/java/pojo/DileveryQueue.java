package pojo;
// Generated Mar 20, 2015 1:53:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * DileveryQueue generated by hbm2java
 */
public class DileveryQueue  implements java.io.Serializable {


     private int qileveryQueueId;
     private Lab lab;
     private Set students = new HashSet(0);
     private Set labs = new HashSet(0);

    public DileveryQueue() {
    }

	
    public DileveryQueue(int qileveryQueueId, Lab lab) {
        this.qileveryQueueId = qileveryQueueId;
        this.lab = lab;
    }
    public DileveryQueue(int qileveryQueueId, Lab lab, Set students, Set labs) {
       this.qileveryQueueId = qileveryQueueId;
       this.lab = lab;
       this.students = students;
       this.labs = labs;
    }
   
    public int getQileveryQueueId() {
        return this.qileveryQueueId;
    }
    
    public void setQileveryQueueId(int qileveryQueueId) {
        this.qileveryQueueId = qileveryQueueId;
    }
    public Lab getLab() {
        return this.lab;
    }
    
    public void setLab(Lab lab) {
        this.lab = lab;
    }
    public Set getStudents() {
        return this.students;
    }
    
    public void setStudents(Set students) {
        this.students = students;
    }
    public Set getLabs() {
        return this.labs;
    }
    
    public void setLabs(Set labs) {
        this.labs = labs;
    }




}


