package org.project.pop_task.acl.models;

public class ERPResponse {
    private final String resourceName;
    private final boolean available;

    public ERPResponse(String resourceName, boolean available) {
        this.resourceName = resourceName;
        this.available = available;
    }

    public String getResourceName() {
        return resourceName;
    }

    public boolean isAvailable() {
        return available;
    }
}