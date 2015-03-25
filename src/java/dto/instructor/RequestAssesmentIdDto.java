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
public class RequestAssesmentIdDto {
    private int studentId;
    private int assesmentQueueId;

    public RequestAssesmentIdDto() {
    }

    public RequestAssesmentIdDto(int studentId, int assesmentQueueId) {
        this.studentId = studentId;
        this.assesmentQueueId = assesmentQueueId;
    }

    public int getAssesmentQueueId() {
        return assesmentQueueId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setAssesmentQueueId(int assesmentQueueId) {
        this.assesmentQueueId = assesmentQueueId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
