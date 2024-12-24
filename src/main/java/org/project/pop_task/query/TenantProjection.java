package org.project.pop_task.query;

import org.project.pop_task.aggregate.Tenant;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TenantProjection {
    private final Map<String, Tenant> tenants = new ConcurrentHashMap<>();

    public void applyDiscount(String tenantId, int ticketCount) {
        tenants.computeIfPresent(tenantId, (id, tenant) -> {
            tenant.applyDiscount(ticketCount);
            return tenant;
        });
    }
}
