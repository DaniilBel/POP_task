package org.project.pop_task.event;

public class TicketCreatedEvent {
    private String ticketId;
    private String category;
    private String description;

    public TicketCreatedEvent(String ticketId, String category, String description) {
        this.ticketId = ticketId;
        this.category = category;
        this.description = description;
    }

    public String getTicketId() { return ticketId; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
}
