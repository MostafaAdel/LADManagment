/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Al-Jazayeerly
 */
public class InstructorDto {
    private int instructorId;
     private String fulName;
     private String userName;
     private String password;

    public InstructorDto(int instructorId, String fulName, String userName, String password) {
        this.instructorId = instructorId;
        this.fulName = fulName;
        this.userName = userName;
        this.password = password;
    }

    public InstructorDto() {
    }

     
    public InstructorDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }
    
    
    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
