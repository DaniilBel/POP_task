package org.project.pop_task.command;

public class CloseTicketCommand {
    private String ticketId;

    public CloseTicketCommand(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() { return ticketId; }
}
