package org.project.pop_task.acl.models;

public class CRMResponse {
    private final String name;
    private final String contactInfo;

    public CRMResponse(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}
