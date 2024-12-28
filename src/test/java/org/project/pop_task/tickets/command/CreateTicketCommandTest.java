package org.project.pop_task.tickets.command;

import org.junit.jupiter.api.Test;
import org.project.pop_task.tickets.query.TicketProjection;
import org.project.pop_task.tickets.query.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTicketCommandTest {
    @Test
    public void testCreateTicket() {
        CreateTicketCommand command = new CreateTicketCommand("New Ticket", "New description");

        command.execute();

        TicketProjection ticket = TicketRepository.findTicketById(1L);
        assertNotNull(ticket);
        assertEquals("New Ticket", ticket.getTitle());
        assertEquals("New description", ticket.getDescription());
        assertFalse(ticket.isClosed());
    }
}
