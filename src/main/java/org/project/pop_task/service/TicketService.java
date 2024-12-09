package org.project.pop_task.service;

import org.project.pop_task.command.AssignAgentCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.domain.Ticket;
import org.project.pop_task.domain.User;
import org.project.pop_task.event.AgentAssignedEvent;
import org.project.pop_task.event.TicketCreatedEvent;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private final Map<String, Ticket> ticketRepository = new HashMap<>();
    private final Map<String, User> userRepository = new HashMap<>();

    // Обработчик для создания тикета
    public void handleCreateTicket(CreateTicketCommand command) {
        String ticketId = "TICKET-" + (ticketRepository.size() + 1);
        Ticket ticket = new Ticket(ticketId, command.getCategory(), command.getDescription(), null);
        ticketRepository.put(ticketId, ticket);

        TicketCreatedEvent event = new TicketCreatedEvent(ticketId, command.getCategory());
        System.out.println("Event: Ticket Created with ID: " + event.getTicketId());
    }

    // Обработчик для назначения агента
    public void handleAssignAgent(AssignAgentCommand command) {
        Ticket ticket = ticketRepository.get(command.getTicketId());
        if (ticket != null) {
            User agent = userRepository.get(command.getAgentId());
            ticket.assignAgent(agent);

            AgentAssignedEvent event = new AgentAssignedEvent(ticket.getTicketId(), command.getAgentId());
            System.out.println("Event: Agent Assigned to Ticket " + event.getTicketId());
        }
    }

    // Инициализация агентов
    public void registerUser(User user) {
        userRepository.put(user.getUserId(), user);
    }
}
