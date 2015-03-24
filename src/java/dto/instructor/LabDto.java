/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.instructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hossam
 */
public class LabDto {
    private Integer labId;
    private AssesmentQueueDto assesmentQueue;
    private CourseDto course;
    private DileveryQueueDto dileveryQueue;
    private Date startDate;
    private Date endDate;
    private String name;
    private Boolean uploadEnabled;
    private Set instructors = new HashSet(0);

    public LabDto(Integer labId, AssesmentQueueDto assesmentQueue, DileveryQueueDto dileveryQueue, Date startDate, Date endDate, String name, Boolean uploadEnabled) {
        this.labId = labId;
        this.assesmentQueue = assesmentQueue;
        this.dileveryQueue = dileveryQueue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.uploadEnabled = uploadEnabled;
    }

    
    public LabDto() {
    }

    public LabDto(AssesmentQueueDto assesmentQueue, CourseDto course, DileveryQueueDto dileveryQueue, Date startDate, Date endDate, String name, Boolean uploadEnabled) {
        this.assesmentQueue = assesmentQueue;
        this.course = course;
        this.dileveryQueue = dileveryQueue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.uploadEnabled = uploadEnabled;
    }

    public Integer getLabId() {
        return labId;
    }

    public AssesmentQueueDto getAssesmentQueue() {
        return assesmentQueue;
    }

    public CourseDto getCourse() {
        return course;
    }

    public DileveryQueueDto getDileveryQueue() {
        return dileveryQueue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public Boolean isUploadEnabled() {
        return uploadEnabled;
    }

    public Set getInstructors() {
        return instructors;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public void setAssesmentQueue(AssesmentQueueDto assesmentQueue) {
        this.assesmentQueue = assesmentQueue;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public void setDileveryQueue(DileveryQueueDto dileveryQueue) {
        this.dileveryQueue = dileveryQueue;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUploadEnabled(Boolean uploadEnabled) {
        this.uploadEnabled = uploadEnabled;
    }

    public void setInstructors(Set instructors) {
        this.instructors = instructors;
    }
    
    
    
}
