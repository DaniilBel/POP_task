package org.project.pop_task.payments.events;

import org.project.pop_task.common.event.BaseEvent;

public class PaymentProcessedEvent extends BaseEvent {

    private final int ticketCount;
    private final double discount;

    public PaymentProcessedEvent(int ticketCount, double discount) {
        this.ticketCount = ticketCount;
        this.discount = discount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public double getDiscount() {
        return discount;
    }
}
