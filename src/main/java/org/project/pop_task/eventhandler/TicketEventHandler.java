package org.project.pop_task.eventhandler;

import org.project.pop_task.event.AgentAssignedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.model.TicketView;
import org.project.pop_task.repository.TicketViewRepository;
import org.springframework.stereotype.Component;

@Component
public class TicketEventHandler {
    private final TicketViewRepository ticketViewRepository;

    public TicketEventHandler(TicketViewRepository repository) {
        this.ticketViewRepository = repository;
    }

    public void handleTicketCreated(TicketCreatedEvent event) {
        TicketView ticketView = new TicketView();
        ticketView.setTicketId(event.getTicketId());
        ticketView.setCategory(event.getCategory());
        ticketView.setDescription(event.getDescription());
        ticketView.setStatus("Open");
        ticketView.setTenantId(event.getTenantId());
        ticketViewRepository.save(ticketView);
    }

    public void handleAgentAssigned(AgentAssignedEvent event) {
        TicketView ticketView = ticketViewRepository.findById(event.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketView.setAssignedAgent(event.getAgentName());
        ticketViewRepository.save(ticketView);
    }

    public void handleTicketClosed(TicketClosedEvent event) {
        TicketView ticketView = ticketViewRepository.findById(event.getTicketId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketView.setStatus("Closed");
        ticketViewRepository.save(ticketView);
    }
}
