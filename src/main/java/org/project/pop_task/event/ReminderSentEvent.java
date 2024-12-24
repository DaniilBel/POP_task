package org.project.pop_task.event;

public class ReminderSentEvent {
    private String ticketId;

    public ReminderSentEvent(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() { return ticketId; }
}
