package org.project.pop_task.Test;

import org.junit.jupiter.api.Test;
import org.project.pop_task.model.User;
import org.project.pop_task.service.TicketService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TicketServiceTest {
    @Test
    void testSendOpenTicketRequest() {
        TicketService ticketService = mock(TicketService.class);
        ticketService.sendOpenTicketRequest("TICKET-1");
        verify(ticketService, times(1)).sendOpenTicketRequest("TICKET-1");
    }

    @Test
    void testSendCloseTicketRequest() {
        TicketService ticketService = mock(TicketService.class);
        ticketService.sendCloseTicketRequest("TICKET-1");
        verify(ticketService, times(1)).sendCloseTicketRequest("TICKET-1");
    }

    @Test
    void testSendAssignAgentRequest() {
        TicketService ticketService = mock(TicketService.class);
        User agent = new User(1, "Agent1", "Agent");
        ticketService.sendAssignAgentRequest("TICKET-1", agent);
        verify(ticketService, times(1)).sendAssignAgentRequest("TICKET-1", agent);
    }
}
