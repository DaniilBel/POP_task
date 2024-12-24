package org.project.pop_task.event;

public class TicketClosedEvent {
    private String ticketId;

    public TicketClosedEvent(String ticketId) {
        this.ticketId = ticketId;
    }

    // Getter
    public String getTicketId() { return ticketId; }
}
