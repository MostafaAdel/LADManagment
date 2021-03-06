package pojo;
// Generated Mar 23, 2015 7:12:27 AM by Hibernate Tools 4.3.1



/**
 * CourseHasGroupsId generated by hbm2java
 */
public class CourseHasGroupsId  implements java.io.Serializable {


     private int courseCourseId;
     private int groupsGroupId;

    public CourseHasGroupsId() {
    }

    public CourseHasGroupsId(int courseCourseId, int groupsGroupId) {
       this.courseCourseId = courseCourseId;
       this.groupsGroupId = groupsGroupId;
    }
   
    public int getCourseCourseId() {
        return this.courseCourseId;
    }
    
    public void setCourseCourseId(int courseCourseId) {
        this.courseCourseId = courseCourseId;
    }
    public int getGroupsGroupId() {
        return this.groupsGroupId;
    }
    
    public void setGroupsGroupId(int groupsGroupId) {
        this.groupsGroupId = groupsGroupId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CourseHasGroupsId) ) return false;
		 CourseHasGroupsId castOther = ( CourseHasGroupsId ) other; 
         
		 return (this.getCourseCourseId()==castOther.getCourseCourseId())
 && (this.getGroupsGroupId()==castOther.getGroupsGroupId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCourseCourseId();
         result = 37 * result + this.getGroupsGroupId();
         return result;
   }   


}


