package org.project.pop_task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TenantView {
    @Id
    private String tenantId;
    private String tenantName;
    private double discountRate;
    private int openTicketCount;

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

    public int getOpenTicketCount() {
        return openTicketCount;
    }

    public void setOpenTicketCount(int openTicketCount) {
        this.openTicketCount = openTicketCount;
    }
}
