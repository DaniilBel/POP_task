package org.project.pop_task.tickets.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.pop_task.tickets.command.TicketAggregate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketQueryServiceTest {
    private TicketQueryService ticketQueryService;

    @BeforeEach
    public void setup() {
        TicketRepository.save(new TicketAggregate(1L, "Open Ticket 1", "Description"));
        TicketRepository.save(new TicketAggregate(2L, "Open Ticket 2", "Description"));
        TicketRepository.save(new TicketAggregate(3L, "Closed Ticket", "Description"));
        TicketAggregate closedTicket = TicketRepository.findById(3L);
        closedTicket.closeTicket();
    }

    @Test
    public void testGetOpenTickets() {
        ticketQueryService = new TicketQueryService(new TicketRepository());

        List<TicketProjection> openTickets = ticketQueryService.getOpenTickets();

        assertEquals(2, openTickets.size());
        assertTrue(openTickets.stream().allMatch(ticket -> !ticket.isClosed()));
    }

    @Test
    public void testGetTicketById() {
        ticketQueryService = new TicketQueryService(new TicketRepository());

        TicketProjection ticket = ticketQueryService.getTicketById(2L);

        assertNotNull(ticket);
        assertEquals("Open Ticket 2", ticket.getTitle());
    }

    @Test
    public void testGetTicketByIdNotFound() {
        ticketQueryService = new TicketQueryService(new TicketRepository());

        TicketProjection ticket = ticketQueryService.getTicketById(99L);

        assertNull(ticket);
    }
}
