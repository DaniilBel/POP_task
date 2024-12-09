package org.project.pop_task.domain;

public class Tenant {
    private String tenantId;
    private String tenantName;
    private double discountRate;

    public Tenant(String tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.discountRate = 0.0;
    }

    public void applyDiscount(int totalTickets) {
        if (totalTickets > 1000) discountRate = 0.30;
        else if (totalTickets > 750) discountRate = 0.20;
        else if (totalTickets > 500) discountRate = 0.10;
        System.out.println("Discount for tenant " + tenantName + " is now " + discountRate * 100 + "%");
    }
}
