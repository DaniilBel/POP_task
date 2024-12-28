package org.project.pop_task.payments.dto;

public class PaymentRequest {

    private int ticketCount;

    public PaymentRequest() {}

    public PaymentRequest(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
