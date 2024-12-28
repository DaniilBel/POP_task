package org.project.pop_task.payments.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.payments.dto.PaymentRequest;
import org.project.pop_task.payments.dto.PaymentResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentServiceTest {

    private PaymentService paymentService;

    @BeforeEach
    void setup() {
        paymentService = new PaymentService();
    }

    @Test
    void testNoDiscountForLowTicketVolume() {
        PaymentRequest request = new PaymentRequest(400);

        PaymentResponse response = paymentService.calculatePayment(request);

        assertEquals(400, response.getTicketCount());
        assertEquals(400.0, response.getTotalCost());
        assertEquals(0.0, response.getDiscountRate());
        assertEquals(400.0, response.getDiscountedCost());
    }

    @Test
    void test10PercentDiscount() {
        PaymentRequest request = new PaymentRequest(600);

        PaymentResponse response = paymentService.calculatePayment(request);

        assertEquals(600, response.getTicketCount());
        assertEquals(600.0, response.getTotalCost());
        assertEquals(0.10, response.getDiscountRate());
        assertEquals(540.0, response.getDiscountedCost());
    }

    @Test
    void test20PercentDiscount() {
        PaymentRequest request = new PaymentRequest(800);

        PaymentResponse response = paymentService.calculatePayment(request);

        assertEquals(800, response.getTicketCount());
        assertEquals(800.0, response.getTotalCost());
        assertEquals(0.20, response.getDiscountRate());
        assertEquals(640.0, response.getDiscountedCost());
    }

    @Test
    void test30PercentDiscount() {
        PaymentRequest request = new PaymentRequest(1200);

        PaymentResponse response = paymentService.calculatePayment(request);

        assertEquals(1200, response.getTicketCount());
        assertEquals(1200.0, response.getTotalCost());
        assertEquals(0.30, response.getDiscountRate());
        assertEquals(840.0, response.getDiscountedCost());
    }
}
