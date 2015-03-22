/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mostafa_ITI
 */
public class GroupDTO {
     private Integer groupId;
     private String name;
     private Set courses = new HashSet(0);
     private Set students = new HashSet(0);

    public GroupDTO(Integer groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public GroupDTO() {
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getCourses() {
        return courses;
    }

    public void setCourses(Set courses) {
        this.courses = courses;
    }

    public Set getStudents() {
        return students;
    }

    public void setStudents(Set students) {
        this.students = students;
    }
    
    
}
