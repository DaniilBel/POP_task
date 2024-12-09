package org.project.pop_task.controller;

import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryController {
    private final TicketViewRepository ticketViewRepository;

    public QueryController(TicketViewRepository repository) {
        this.ticketViewRepository = repository;
    }

    @GetMapping("/tickets/active")
    public List<TicketView> getAllActiveTickets() {
        return ticketViewRepository.findByStatus("Open");
    }

    @GetMapping("/tickets/agent/{agentName}")
    public List<TicketView> getTicketsByAgent(@PathVariable String agentName) {
        return ticketViewRepository.findByAssignedAgent(agentName);
    }

    @GetMapping("/tickets/{ticketId}")
    public TicketView getTicketById(@PathVariable int ticketId) {
        return ticketViewRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
