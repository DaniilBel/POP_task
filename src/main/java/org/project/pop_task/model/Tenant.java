package org.project.pop_task.model;

public class Tenant {
    private String tenantId;
    private String tenantName;
    private double discountRate;

    public void applyDiscount(int totalTickets) {
        if (totalTickets > 1000) discountRate = 0.30;
        else if (totalTickets > 750) discountRate = 0.20;
        else if (totalTickets > 500) discountRate = 0.10;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
