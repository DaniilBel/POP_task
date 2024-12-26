package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.pop_task.acl.models.CRMResponse;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class CRMClientTest {
    @Test
    public void testFetchClientData() {
        RestTemplate mockRestTemplate = Mockito.mock(RestTemplate.class);
        String crmBaseUrl = "https://api.crm-system.com";
        CRMClient crmClient = new CRMClient(mockRestTemplate, crmBaseUrl);

        String clientId = "123";
        String expectedUrl = crmBaseUrl + "/clients/" + clientId;

        CRMResponse mockResponse = new CRMResponse("John Doe", "john.doe@example.com");
        when(mockRestTemplate.getForObject(eq(expectedUrl), eq(CRMResponse.class))).thenReturn(mockResponse);

        CRMResponse response = crmClient.fetchClientData(clientId);

        assertEquals("John Doe", response.getName());
        assertEquals("john.doe@example.com", response.getContactInfo());
    }
}
