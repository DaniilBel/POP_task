package org.project.pop_task.fraud_detection.service;

import org.project.pop_task.fraud_detection.dto.FraudRequest;
import org.project.pop_task.fraud_detection.dto.FraudResponse;
import org.project.pop_task.fraud_detection.model.FraudCheckResult;
import org.project.pop_task.fraud_detection.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudDetectionService {

    @Autowired
    private FraudRepository fraudRepository;

    private static final String[] FRAUD_KEYWORDS = {"spam", "money", "lottery", "win"};

    public FraudResponse checkFraud(FraudRequest request) {
        String description = request.getTicketDescription();

        for (String keyword : FRAUD_KEYWORDS) {
            if (description.contains(keyword)) {
                return saveAndRespond(description, true, "Contains fraud keyword: " + keyword);
            }
        }

        return saveAndRespond(description, false, "No fraud detected");
    }

    private FraudResponse saveAndRespond(String description, boolean isFraudulent, String reason) {
        FraudCheckResult result = new FraudCheckResult();
        result.setTicketDescription(description);
        result.setIsFraudulent(isFraudulent);
        result.setReason(reason);
        fraudRepository.save(result);

        FraudResponse response = new FraudResponse();
        response.setIsFraudulent(isFraudulent);
        response.setReason(reason);
        return response;
    }
}
