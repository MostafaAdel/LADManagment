/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Mostafa_ITI
 */
public class CourseDTO {

    private Integer courseId;
    private String name;

    public CourseDTO(Integer courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public CourseDTO() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
