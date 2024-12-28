package org.project.pop_task.payments.service;

import org.project.pop_task.payments.dto.PaymentRequest;
import org.project.pop_task.payments.dto.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final double BASE_PRICE_PER_TICKET = 1.0;

    public PaymentResponse calculatePayment(PaymentRequest request) {
        int ticketCount = request.getTicketCount();
        double discount = calculateDiscount(ticketCount);
        double totalCost = ticketCount * BASE_PRICE_PER_TICKET;
        double discountedCost = totalCost * (1 - discount);

        return new PaymentResponse(ticketCount, totalCost, discount, discountedCost);
    }

    private double calculateDiscount(int ticketCount) {
        if (ticketCount > 1000) {
            return 0.30;
        } else if (ticketCount > 750) {
            return 0.20;
        } else if (ticketCount > 500) {
            return 0.10;
        }
        return 0.0;
    }
}
