package org.project.pop_task.service;

import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QueryService {
    private final TicketViewRepository ticketViewRepository;

    public QueryService(TicketViewRepository repository) {
        this.ticketViewRepository = repository;
    }

    public List<TicketView> getTicketsClosedInLast7Days() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        // Example of custom query (for demonstration)
        return ticketViewRepository.findByStatus("Closed");
    }
}
