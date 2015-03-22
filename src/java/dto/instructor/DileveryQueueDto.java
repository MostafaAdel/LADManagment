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
public class DileveryQueueDto {
    private Integer dileveryQueueId;
    private Set students = new HashSet(0);

    public DileveryQueueDto() {
    }

    public void setDileveryQueueId(Integer dileveryQueueId) {
        this.dileveryQueueId = dileveryQueueId;
    }

    public void setStudents(Set students) {
        this.students = students;
    }

    public Integer getDileveryQueueId() {
        return dileveryQueueId;
    }

    public Set getStudents() {
        return students;
    }
     
    
}
