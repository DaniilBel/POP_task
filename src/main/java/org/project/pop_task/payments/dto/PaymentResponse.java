package org.project.pop_task.payments.dto;

public class PaymentResponse {

    private int ticketCount;
    private double totalCost;
    private double discountRate;
    private double discountedCost;

    public PaymentResponse(int ticketCount, double totalCost, double discountRate, double discountedCost) {
        this.ticketCount = ticketCount;
        this.totalCost = totalCost;
        this.discountRate = discountRate;
        this.discountedCost = discountedCost;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getDiscountedCost() {
        return discountedCost;
    }
}
