package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.pop_task.acl.models.ERPResponse;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ERPClientTest {
    @Test
    public void testFetchResourceData() {
        RestTemplate mockRestTemplate = Mockito.mock(RestTemplate.class);
        String erpBaseUrl = "https://api.erp-system.com";
        ERPClient erpClient = new ERPClient(mockRestTemplate, erpBaseUrl);

        String resourceId = "res123";
        String expectedUrl = erpBaseUrl + "/resources/" + resourceId;

        ERPResponse mockResponse = new ERPResponse("Resource1", true);
        when(mockRestTemplate.getForObject(eq(expectedUrl), eq(ERPResponse.class))).thenReturn(mockResponse);

        ERPResponse response = erpClient.fetchResourceData(resourceId);

        assertEquals("Resource1", response.getResourceName());
        assertEquals(true, response.isAvailable());
    }
}
