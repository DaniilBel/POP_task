package org.project.pop_task.fraud_detection.repository;

import org.project.pop_task.fraud_detection.model.FraudCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckResult, Long> {
}
