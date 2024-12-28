package org.project.pop_task.tickets.client;

import org.springframework.stereotype.Service;

@Service
public class FraudDetectionClient {
    public boolean isFraudulent(String content) {
        return content.toLowerCase().contains("spam");
    }
}
