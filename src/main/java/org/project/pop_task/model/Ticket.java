package org.project.pop_task.model;

public class Ticket {
    private static int counter = 1;
    private int ticketId;
    private String category;
    private String description;
    private String status;
    private User assignedAgent;

    public Ticket(String category, String description) {
        this.ticketId = counter++;
        this.category = category;
        this.description = description;
        this.status = "Open";
    }

    public void open() {
        if ("Open".equals(this.status)) {
            throw new IllegalStateException("Ticket is already open.");
        }
        this.status = "Open";
    }

    public void close() {
        if ("Closed".equals(this.status)) {
            throw new IllegalStateException("Ticket is already closed.");
        }
        this.status = "Closed";
    }

    public void assignAgent(User agent) {
        if (!"Agent".equals(agent.getRole())) {
            throw new IllegalArgumentException("Only users with role 'Agent' can be assigned to a ticket.");
        }
        this.assignedAgent = agent;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedAgent() {
        return assignedAgent;
    }

    public void setAssignedAgent(User assignedAgent) {
        this.assignedAgent = assignedAgent;
    }
}
