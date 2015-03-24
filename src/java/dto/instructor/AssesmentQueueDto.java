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
public class AssesmentQueueDto {
    private Integer assesmentQueueId;
    private Set requestAssesments = new HashSet(0);

    public AssesmentQueueDto() {
    }

    public Integer getAssesmentQueueId() {
        return assesmentQueueId;
    }

    public Set getRequestAssesments() {
        return requestAssesments;
    }

    public void setAssesmentQueueId(Integer assesmentQueueId) {
        this.assesmentQueueId = assesmentQueueId;
    }

    public void setRequestAssesments(Set requestAssesments) {
        this.requestAssesments = requestAssesments;
    }
    
}
