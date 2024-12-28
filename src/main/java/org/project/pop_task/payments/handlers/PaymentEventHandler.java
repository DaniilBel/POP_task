package org.project.pop_task.payments.handlers;

import org.project.pop_task.payments.events.PaymentProcessedEvent;

public class PaymentEventHandler {

    public void handlePaymentProcessed(PaymentProcessedEvent event) {
        System.out.println("Handling PaymentProcessedEvent. Discount: " + event.getDiscount());
    }
}
