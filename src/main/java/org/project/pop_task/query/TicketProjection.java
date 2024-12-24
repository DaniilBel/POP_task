package org.project.pop_task.query;

import org.project.pop_task.aggregate.Ticket;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TicketProjection {
    private final Map<String, Ticket> tickets = new ConcurrentHashMap<>();

    @EventListener
    public void onTicketCreated(TicketCreatedEvent event) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(event.getTicketId());
        ticket.setCategory(event.getCategory());
        ticket.setDescription(event.getDescription());
        ticket.setStatus("CREATED");
        tickets.put(event.getTicketId(), ticket);
    }

    @EventListener
    public void onTicketClosed(TicketClosedEvent event) {
        tickets.computeIfPresent(event.getTicketId(), (id, ticket) -> {
            ticket.setStatus("CLOSED");
            return ticket;
        });
    }

    public Ticket getTicket(String ticketId) {
        return tickets.get(ticketId);
    }
}
