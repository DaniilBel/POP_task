package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.pop_task.acl.models.ResourceInfo;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ERPResourceTest {
    @Test
    public void testGetResourceAvailability_Success() {
        ERPService mockERPService = Mockito.mock(ERPService.class);
        ERPResource erpResource = new ERPResource(mockERPService);

        String resourceId = "res123";
        ResourceInfo mockResourceInfo = new ResourceInfo("Resource1", true);

        when(mockERPService.checkResourceAvailability(resourceId)).thenReturn(mockResourceInfo);

        ResponseEntity<ResourceInfo> response = erpResource.getResourceAvailability(resourceId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Resource1", response.getBody().getResourceName());
        assertTrue(response.getBody().isAvailable());
    }

    @Test
    public void testGetResourceAvailability_BadRequest() {
        ERPService mockERPService = Mockito.mock(ERPService.class);
        ERPResource erpResource = new ERPResource(mockERPService);

        String resourceId = "invalid";

        when(mockERPService.checkResourceAvailability(resourceId)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<ResourceInfo> response = erpResource.getResourceAvailability(resourceId);

        assertEquals(400, response.getStatusCodeValue());
        assertNull(response.getBody());
    }
}
