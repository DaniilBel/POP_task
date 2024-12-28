package org.project.pop_task.tickets.query;

import java.util.List;

public class TicketQueryService {

    public TicketQueryService(TicketRepository ticketRepository) {
    }

    public List<TicketProjection> getOpenTickets() {
        return TicketRepository.findAllOpenTickets();
    }

    public TicketProjection getTicketById(Long id) {
        return TicketRepository.findTicketById(id);
    }
}
