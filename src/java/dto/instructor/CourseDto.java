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
    private Set groupses = new HashSet(0);

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

    public Set getGroupses() {
        return groupses;
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

    public void setGroupses(Set groupses) {
        this.groupses = groupses;
    }
}
