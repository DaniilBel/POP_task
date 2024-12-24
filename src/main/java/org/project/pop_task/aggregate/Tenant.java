package org.project.pop_task.aggregate;

public class Tenant {
    private String tenantId;
    private String tenantName;
    private double discountRate;

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    public double getDiscountRate() { return discountRate; }
    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    public void applyDiscount(int ticketCount) {
        if (ticketCount > 1000) discountRate = 0.3;
        else if (ticketCount > 750) discountRate = 0.2;
        else if (ticketCount > 500) discountRate = 0.1;
        else discountRate = 0.0;
    }
}