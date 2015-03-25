/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.instructor;




/**
 *
 * @author Hossam
 */
public class RequestAssesmentDto {
    private RequestAssesmentIdDto id;
    private AssesmentQueueDto assesmentQueue;
    private StudentDto student;
    private Integer numberOfRequests;
    /////////////////////////////////////////////////////////
    //////////////////to be added to database////////////////
    /////after adding to DB this comment must be deleted/////
    /////////////////////////////////////////////////////////
    private boolean ExistInQueue;

    public RequestAssesmentDto() {
    }

    public RequestAssesmentDto(AssesmentQueueDto assesmentQueue, StudentDto student, Integer numberOfRequests, boolean ExistInQueue) {
        this.assesmentQueue = assesmentQueue;
        this.student = student;
        this.numberOfRequests = numberOfRequests;
        this.ExistInQueue = ExistInQueue;
    }

    public boolean isExistInQueue() {
        return ExistInQueue;
    }

    public RequestAssesmentIdDto getId() {
        return id;
    }

    public AssesmentQueueDto getAssesmentQueue() {
        return assesmentQueue;
    }

    public StudentDto getStudent() {
        return student;
    }

    public Integer getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setExistInQueue(boolean ExistInQueue) {
        this.ExistInQueue = ExistInQueue;
    }
    
    public void setId(RequestAssesmentIdDto id) {
        this.id = id;
    }

    public void setAssesmentQueue(AssesmentQueueDto assesmentQueue) {
        this.assesmentQueue = assesmentQueue;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public void setNumberOfRequests(Integer numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }
    
    
}
