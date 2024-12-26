package org.project.pop_task.acl;

import org.project.pop_task.acl.models.CRMResponse;
import org.project.pop_task.acl.models.ClientInfo;

public class CRMAdapter {
    private final CRMClient crmClient;

    public CRMAdapter(CRMClient crmClient) {
        this.crmClient = crmClient;
    }

    public ClientInfo getClientInfo(String clientId) {
        CRMResponse response = crmClient.fetchClientData(clientId);
        return new ClientInfo(response.getName(), response.getContactInfo());
    }
}
