package org.project.pop_task.tickets.query;

import org.project.pop_task.tickets.command.TicketAggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketRepository {
    private static final List<TicketAggregate> tickets = new ArrayList<>();

    public static void save(TicketAggregate ticket) {
        tickets.add(ticket);
    }

    public static TicketAggregate findById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found."));
    }

    public static List<TicketProjection> findAllOpenTickets() {
        return tickets.stream()
                .filter(ticket -> !ticket.isClosed())
                .map(TicketProjection::fromAggregate)
                .collect(Collectors.toList());
    }

    public static TicketProjection findTicketById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .map(TicketProjection::fromAggregate)
                .findFirst()
                .orElse(null);
    }
}
