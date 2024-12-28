package org.project.pop_task.tickets.command;

import org.project.pop_task.common.command.BaseCommand;
import org.project.pop_task.tickets.query.TicketRepository;

public class CloseTicketCommand implements BaseCommand {
    private final Long ticketId;

    public CloseTicketCommand(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public void execute() {
        System.out.println("Closing ticket with ID: " + ticketId);
        TicketAggregate ticket = TicketRepository.findById(ticketId);
        ticket.closeTicket();
    }
}
