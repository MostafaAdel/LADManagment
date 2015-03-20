package pojo;
// Generated Mar 20, 2015 5:17:41 PM by Hibernate Tools 4.3.1



/**
 * RequestAssesmentId generated by hbm2java
 */
public class RequestAssesmentId  implements java.io.Serializable {


     private int studentId;
     private int assesmentQueueId;

    public RequestAssesmentId() {
    }

    public RequestAssesmentId(int studentId, int assesmentQueueId) {
       this.studentId = studentId;
       this.assesmentQueueId = assesmentQueueId;
    }
   
    public int getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public int getAssesmentQueueId() {
        return this.assesmentQueueId;
    }
    
    public void setAssesmentQueueId(int assesmentQueueId) {
        this.assesmentQueueId = assesmentQueueId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RequestAssesmentId) ) return false;
		 RequestAssesmentId castOther = ( RequestAssesmentId ) other; 
         
		 return (this.getStudentId()==castOther.getStudentId())
 && (this.getAssesmentQueueId()==castOther.getAssesmentQueueId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getStudentId();
         result = 37 * result + this.getAssesmentQueueId();
         return result;
   }   


}


