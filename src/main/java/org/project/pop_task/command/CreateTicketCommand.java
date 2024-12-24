package org.project.pop_task.command;

public class CreateTicketCommand {
    private String category;
    private String description;
    private String tenantId;

    public CreateTicketCommand(String category, String description, String tenantId) {
        this.category = category;
        this.description = description;
        this.tenantId = tenantId;
    }

    // Getters
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getTenantId() { return tenantId; }
}