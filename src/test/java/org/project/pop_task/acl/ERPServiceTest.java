package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.pop_task.acl.models.ERPResponse;
import org.project.pop_task.acl.models.ResourceInfo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ERPServiceTest {
    @Test
    public void testCheckResourceAvailability_Success() {
        ERPClient mockERPClient = Mockito.mock(ERPClient.class);
        ERPService erpService = new ERPService(mockERPClient);

        String resourceId = "res123";
        ERPResponse mockResponse = new ERPResponse("Resource1", true);

        when(mockERPClient.fetchResourceData(resourceId)).thenReturn(mockResponse);

        ResourceInfo resourceInfo = erpService.checkResourceAvailability(resourceId);

        assertEquals("Resource1", resourceInfo.getResourceName());
        assertTrue(resourceInfo.isAvailable());
    }

    @Test
    public void testCheckResourceAvailability_InvalidResource() {
        ERPClient mockERPClient = Mockito.mock(ERPClient.class);
        ERPService erpService = new ERPService(mockERPClient);

        when(mockERPClient.fetchResourceData("invalid")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> erpService.checkResourceAvailability("invalid"));
    }
}
