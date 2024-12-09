package org.project.pop_task.event;

public class TicketCreatedEvent {
    private String ticketId;
    private String category;

    public TicketCreatedEvent(String ticketId, String category) {
        this.ticketId = ticketId;
        this.category = category;
    }

    public String getTicketId() { return ticketId; }
    public String getCategory() { return category; }
}
