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
 * @author Al-Jazayeerly
 */
public class StudentDto{

    private Integer studentId;
    private String fulName;
    private String userName;
    private String password;
    private Set assignments = new HashSet(0);

    public StudentDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    
    public StudentDto(Integer studentId, String fulName, String userName, String password) {
        this.studentId = studentId;
        this.fulName = fulName;
        this.userName = userName;
        this.password = password;
    }

    public StudentDto() {
    }

    public StudentDto(String fulName, String userName, String password) {
        this.fulName = fulName;
        this.userName = userName;
        this.password = password;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getFulName() {
        return fulName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Set getAssignments() {
        return assignments;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAssignments(Set assignments) {
        this.assignments = assignments;
    }
 

}
