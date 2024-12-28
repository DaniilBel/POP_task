package org.project.pop_task.fraud_detection.dto;

import lombok.Data;

@Data
public class FraudResponse {
//    @Setter
    private boolean isFraudulent;
    private String reason;

    public void setIsFraudulent(boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }
}
