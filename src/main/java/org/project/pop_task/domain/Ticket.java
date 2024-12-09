package org.project.pop_task.domain;

public class Ticket {
    private String ticketId;
    private String category;
    private String description;
    private String status;
    private User assignedAgent;
    private Tenant tenant;

    // Конструктор
    public Ticket(String ticketId, String category, String description, Tenant tenant) {
        this.ticketId = ticketId;
        this.category = category;
        this.description = description;
        this.status = "OPEN";
        this.tenant = tenant;
    }

    // Методы
    public void assignAgent(User agent) {
        if (!"CLOSED".equals(status)) {
            this.assignedAgent = agent;
            System.out.println("Agent " + agent.getUserName() + " assigned to ticket " + ticketId);
        }
    }

    public void close() {
        this.status = "CLOSED";
        System.out.println("Ticket " + ticketId + " has been closed.");
    }

    // Геттеры и сеттеры
    public String getTicketId() { return ticketId; }
    public String getStatus() { return status; }
}
