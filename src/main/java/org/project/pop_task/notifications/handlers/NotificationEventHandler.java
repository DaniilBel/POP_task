package org.project.pop_task.notifications.handlers;

import org.project.pop_task.tickets.event.TicketClosedEvent;
import org.project.pop_task.tickets.event.TicketCreatedEvent;

public class NotificationEventHandler {

    public void handleTicketCreated(TicketCreatedEvent event) {
        System.out.println("Sending notification for new ticket: " + event.getTitle());
    }

    public void handleTicketClosed(TicketClosedEvent event) {
        System.out.println("Sending notification for closed ticket: " + event.getTicketId());
    }
}
