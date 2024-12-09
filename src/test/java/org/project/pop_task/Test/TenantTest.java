package org.project.pop_task.Test;

import org.junit.jupiter.api.Test;
import org.project.pop_task.model.Tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenantTest {
    @Test
    void testApplyDiscount() {
        Tenant tenant = new Tenant();
        tenant.applyDiscount(600);
        assertEquals(0.10, tenant.getDiscountRate(), 0.01);
    }
}
