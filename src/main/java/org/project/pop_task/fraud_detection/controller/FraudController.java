package org.project.pop_task.fraud_detection.controller;

import org.project.pop_task.fraud_detection.dto.FraudRequest;
import org.project.pop_task.fraud_detection.dto.FraudResponse;
import org.project.pop_task.fraud_detection.service.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud")
public class FraudController {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @PostMapping("/check")
    public ResponseEntity<FraudResponse> checkFraud(@RequestBody FraudRequest request) {
        FraudResponse response = fraudDetectionService.checkFraud(request);
        return ResponseEntity.ok(response);
    }
}
