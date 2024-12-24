package org.project.pop_task.handler;

import org.junit.jupiter.api.Test;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.query.TicketProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TicketEventHandlerTest {
    @Autowired
    private TicketEventHandler handler;

    @MockBean
    private TicketProjection ticketProjection;

    @Test
    public void testOnTicketCreated() {
        TicketCreatedEvent event = new TicketCreatedEvent("Support", "Issue description", "ticket123");
        handler.onTicketCreated(event);

        verify(ticketProjection).onTicketCreated(event);
    }

    @Test
    public void testOnTicketClosed() {
        TicketClosedEvent event = new TicketClosedEvent("ticket123");

        handler.onTicketClosed(event);

        verify(ticketProjection, times(1)).onTicketClosed(event);
    }
}
