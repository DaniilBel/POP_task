package org.project.pop_task.handler;

import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.query.TicketProjection;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TicketEventHandler {
    private final TicketProjection ticketProjection;

    public TicketEventHandler(TicketProjection ticketProjection) {
        this.ticketProjection = ticketProjection;
    }

    @EventListener
    public void onTicketCreated(TicketCreatedEvent event) {
        ticketProjection.onTicketCreated(event);
    }

    @EventListener
    public void onTicketClosed(TicketClosedEvent event) {
        ticketProjection.onTicketClosed(event);
    }
}
