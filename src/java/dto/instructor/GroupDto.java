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
public class GroupDto {
     private Integer groupId;
     private String name;
     private Set students = new HashSet(0);

    public GroupDto() {
    }

    public GroupDto(String name) {
        this.name = name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public Set getStudents() {
        return students;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(Set students) {
        this.students = students;
    }
}