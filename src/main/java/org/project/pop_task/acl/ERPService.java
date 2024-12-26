package org.project.pop_task.acl;

import org.project.pop_task.acl.models.ERPResponse;
import org.project.pop_task.acl.models.ResourceInfo;
import org.springframework.stereotype.Service;

@Service
public class ERPService {

    private final ERPClient erpClient;

    public ERPService(ERPClient erpClient) {
        this.erpClient = erpClient;
    }

    public ResourceInfo checkResourceAvailability(String resourceId) {
        ERPResponse response = erpClient.fetchResourceData(resourceId);

        if (response == null) {
            throw new IllegalArgumentException("Invalid resource ID or ERP system unavailable.");
        }

        return new ResourceInfo(response.getResourceName(), response.isAvailable());
    }
}
