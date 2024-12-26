package org.project.pop_task.acl;

import org.junit.jupiter.api.Test;
import org.project.pop_task.acl.models.CRMResponse;
import org.project.pop_task.acl.models.ClientInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CRMAdapterTest {
    @Test
    public void testGetClientInfo() {
        CRMClient mockCRMClient = mock(CRMClient.class);
        CRMResponse mockResponse = new CRMResponse("John Doe", "john.doe@example.com");

        when(mockCRMClient.fetchClientData("123")).thenReturn(mockResponse);

        CRMAdapter crmAdapter = new CRMAdapter(mockCRMClient);
        ClientInfo clientInfo = crmAdapter.getClientInfo("123");

        assertEquals("John Doe", clientInfo.getName());
        assertEquals("john.doe@example.com", clientInfo.getContactInfo());
    }
}
