package org.project.pop_task.tickets.service;

import org.project.pop_task.tickets.client.AgentServiceClient;
import org.project.pop_task.tickets.client.FraudDetectionClient;
import org.project.pop_task.tickets.client.NotificationClient;
import org.project.pop_task.tickets.dto.TicketRequest;
import org.project.pop_task.tickets.model.Ticket;
import org.project.pop_task.tickets.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FraudDetectionClient fraudDetectionClient;

    @Autowired
    private AgentServiceClient agentServiceClient;

    @Autowired
    private NotificationClient notificationClient;

    public Ticket createTicket(TicketRequest request) {
        // Check for fraud
        if (fraudDetectionClient.isFraudulent(request.getDescription())) {
            throw new IllegalArgumentException("Fraudulent content detected");
        }

        // Create and save ticket
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setCategory(request.getCategory());
        ticket.setStatus("OPEN");
        ticket = ticketRepository.save(ticket);

        // Assign to agent
        String assignedAgentId = agentServiceClient.assignAgent(ticket.getCategory());
        ticket.setAssignedAgentId(assignedAgentId);
        ticketRepository.save(ticket);

        // Notify
        notificationClient.notifyAgent(assignedAgentId, ticket);

        return ticket;
    }

    public List<Ticket> getOpenTickets() {
        return ticketRepository.findByStatus("OPEN");
    }

    public void closeInactiveTickets() {
        List<Ticket> inactiveTickets = ticketRepository.findByStatus("PENDING");
        inactiveTickets.forEach(ticket -> {
            ticket.setStatus("CLOSED");
            ticketRepository.save(ticket);
        });
    }
}
