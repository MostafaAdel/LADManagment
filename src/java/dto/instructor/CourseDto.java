/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.instructor;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hossam
 */
public class CourseDto {
    private Integer courseId;
    private String name;
    private Set labs = new HashSet(0);
    private GroupDto group=new GroupDto() ;

    public GroupDto getGroup() {
        return group;
    }

    public CourseDto(Integer courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }
    
    
    public void setGroup(GroupDto group) {
        this.group = group;
    }
    
    public CourseDto() {
    }

    public CourseDto(String name) {
        this.name = name;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Set getLabs() {
        return labs;
    }

   
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabs(Set labs) {
        this.labs = labs;
    }

    
}
