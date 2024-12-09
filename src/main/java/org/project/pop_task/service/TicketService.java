package org.project.pop_task.service;

import org.project.pop_task.command.AssignAgentCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.model.Ticket;
import org.project.pop_task.model.User;
import org.project.pop_task.event.AgentAssignedEvent;
import org.project.pop_task.event.TicketCreatedEvent;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private final Map<String, Ticket> ticketRepository = new HashMap<>();

    public Ticket getTicket(String ticketId) {
        return ticketRepository.get(ticketId);
    }

    public void sendOpenTicketRequest(String ticketId) {
        System.out.println("Sending request to server to open ticket: " + ticketId);
    }

    public void sendCloseTicketRequest(String ticketId) {
        System.out.println("Sending request to server to close ticket: " + ticketId);
    }

    public void sendAssignAgentRequest(String ticketId, User agent) {
        System.out.println("Sending request to server to assign agent to ticket: " + ticketId);
    }
}
