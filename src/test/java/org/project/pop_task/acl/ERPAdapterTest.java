package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.project.pop_task.acl.models.ERPResponse;
import org.project.pop_task.acl.models.ResourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ERPAdapterTest {
    @Test
    public void testCheckResourceAvailability() {
        ERPClient mockERPClient = mock(ERPClient.class);
        ERPResponse mockResponse = new ERPResponse("Resource1", true);

        when(mockERPClient.fetchResourceData("res123")).thenReturn(mockResponse);

        ERPAdapter erpAdapter = new ERPAdapter(mockERPClient);
        ResourceInfo resourceInfo = erpAdapter.getResourceAvailability("res123");

        assertEquals("Resource1", resourceInfo.getResourceName());
        assertEquals(true, resourceInfo.isAvailable());
    }
}
