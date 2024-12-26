package org.project.pop_task.acl.models;

public class ResourceInfo {
    private final String resourceName;
    private final boolean isAvailable;

    public ResourceInfo(String resourceName, boolean isAvailable) {
        this.resourceName = resourceName;
        this.isAvailable = isAvailable;
    }

    public String getResourceName() {
        return resourceName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
