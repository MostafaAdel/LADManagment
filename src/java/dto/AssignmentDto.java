/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import pojo.Lab;
import pojo.Student;

/**
 *
 * @author Al-Jazayeerly
 */
public class AssignmentDto implements Dto {

    private int assignmentId;
    private Lab lab;
    private Student student;
    private String name;
    private String url;

    public AssignmentDto() {
    }

    public AssignmentDto(int assignmentId, Lab lab, Student student) {
        this.assignmentId = assignmentId;
        this.lab = lab;
        this.student = student;
    }

    public AssignmentDto(int assignmentId, Lab lab, Student student, String name, String url) {
        this.assignmentId = assignmentId;
        this.lab = lab;
        this.student = student;
        this.name = name;
        this.url = url;
    }

    public int getAssignmentId() {
        return this.assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Lab getLab() {
        return this.lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
