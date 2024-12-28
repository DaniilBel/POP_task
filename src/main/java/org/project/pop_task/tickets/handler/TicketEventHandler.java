package org.project.pop_task.tickets.handler;

import org.project.pop_task.tickets.event.TicketClosedEvent;
import org.project.pop_task.tickets.event.TicketCreatedEvent;

public class TicketEventHandler {

    public void handleTicketCreated(TicketCreatedEvent event) {
        System.out.println("Handling TicketCreatedEvent: " + event.getTitle());
    }

    public void handleTicketClosed(TicketClosedEvent event) {
        System.out.println("Handling TicketClosedEvent for ticket ID: " + event.getTicketId());
    }
}
