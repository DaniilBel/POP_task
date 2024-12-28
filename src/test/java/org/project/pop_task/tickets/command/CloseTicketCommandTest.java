package org.project.pop_task.tickets.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.tickets.query.TicketProjection;
import org.project.pop_task.tickets.query.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CloseTicketCommandTest {
    @BeforeEach
    public void setup() {
        TicketRepository.save(new TicketAggregate(1L, "Open Ticket", "Needs closure"));
    }

    @Test
    public void testCloseTicketSuccessfully() {
        CloseTicketCommand closeCommand = new CloseTicketCommand(1L);

        closeCommand.execute();

        TicketProjection ticket = TicketRepository.findTicketById(1L);
        assertNotNull(ticket);
        assertTrue(ticket.isClosed());
    }

    @Test
    public void testCloseAlreadyClosedTicket() {
        CloseTicketCommand closeCommand = new CloseTicketCommand(1L);
        closeCommand.execute();

        assertThrows(IllegalStateException.class, () -> {
            closeCommand.execute();
        });
    }
}
