package org.project.pop_task.acl;

import org.project.pop_task.acl.models.ERPResponse;
import org.project.pop_task.acl.models.ResourceInfo;
import org.springframework.stereotype.Component;

@Component
public class ERPAdapter {

    private final ERPClient erpClient;

    public ERPAdapter(ERPClient erpClient) {
        this.erpClient = erpClient;
    }

    /**
     * Fetches resource availability from the ERP system and transforms it into the internal model.
     *
     * @param resourceId The resource ID to check.
     * @return A ResourceInfo object containing the resource name and availability status.
     */
    public ResourceInfo getResourceAvailability(String resourceId) {
        ERPResponse response = erpClient.fetchResourceData(resourceId);

        if (response == null) {
            throw new IllegalArgumentException("Resource not found in ERP system for ID: " + resourceId);
        }

        // Transform the ERPResponse into the internal ResourceInfo model.
        return new ResourceInfo(response.getResourceName(), response.isAvailable());
    }
}
