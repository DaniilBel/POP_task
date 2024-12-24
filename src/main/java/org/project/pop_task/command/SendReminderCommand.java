package org.project.pop_task.command;

public class SendReminderCommand {
    private String ticketId;

    public SendReminderCommand(String ticketId) {
        this.ticketId = ticketId;
    }

    // Getter
    public String getTicketId() { return ticketId; }
}
