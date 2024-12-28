package org.project.pop_task.fraud_detection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FraudCheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketDescription;
    private boolean isFraudulent;
    private String reason;

    public void setIsFraudulent(boolean isFraudulent) {
        this.isFraudulent = isFraudulent;
    }
}
