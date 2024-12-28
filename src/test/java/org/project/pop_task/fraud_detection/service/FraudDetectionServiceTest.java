package org.project.pop_task.fraud_detection.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.project.pop_task.fraud_detection.dto.FraudRequest;
import org.project.pop_task.fraud_detection.dto.FraudResponse;
import org.project.pop_task.fraud_detection.model.FraudCheckResult;
import org.project.pop_task.fraud_detection.repository.FraudRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FraudDetectionServiceTest {

    @InjectMocks
    private FraudDetectionService fraudDetectionService;

    @Mock
    private FraudRepository fraudRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFraudulentTicketWithKeyword() {
        FraudRequest request = new FraudRequest();
        request.setTicketDescription("You just won a lottery!");

        FraudResponse response = fraudDetectionService.checkFraud(request);

        assertTrue(response.isFraudulent());
        assertEquals("Contains fraud keyword: lottery", response.getReason());

        ArgumentCaptor<FraudCheckResult> captor = ArgumentCaptor.forClass(FraudCheckResult.class);
        verify(fraudRepository).save(captor.capture());
        assertEquals("You just won a lottery!", captor.getValue().getTicketDescription());
        assertTrue(captor.getValue().isFraudulent());
    }

    @Test
    void testNonFraudulentTicket() {
        FraudRequest request = new FraudRequest();
        request.setTicketDescription("Hello, I need help with my account.");

        FraudResponse response = fraudDetectionService.checkFraud(request);

        assertFalse(response.isFraudulent());
        assertEquals("No fraud detected", response.getReason());

        ArgumentCaptor<FraudCheckResult> captor = ArgumentCaptor.forClass(FraudCheckResult.class);
        verify(fraudRepository).save(captor.capture());
        assertEquals("Hello, I need help with my account.", captor.getValue().getTicketDescription());
        assertFalse(captor.getValue().isFraudulent());
    }

    @Test
    void testFraudulentTicketSavedCorrectly() {
        FraudCheckResult mockResult = new FraudCheckResult();
        mockResult.setId(1L);
        mockResult.setTicketDescription("Spam message example");
        mockResult.setIsFraudulent(true);
        mockResult.setReason("Contains fraud keyword: spam");

        when(fraudRepository.findById(1L)).thenReturn(Optional.of(mockResult));

        Optional<FraudCheckResult> result = fraudRepository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Spam message example", result.get().getTicketDescription());
        assertTrue(result.get().isFraudulent());
        assertEquals("Contains fraud keyword: spam", result.get().getReason());
    }
}
