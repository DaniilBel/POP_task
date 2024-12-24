package org.project.pop_task.orchestrator;

import org.project.pop_task.aggregate.Ticket;
import org.project.pop_task.command.AssignAgentCommand;
import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.command.SendReminderCommand;
import org.project.pop_task.event.AgentAssignedEvent;
import org.project.pop_task.event.ReminderSentEvent;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.publisher.EventPublisher;
import org.project.pop_task.util.DeadlineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TicketOrchestrator {
    private final EventPublisher eventPublisher;

    public TicketOrchestrator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createTicket(CreateTicketCommand command) {
//        String ticketId = UUID.randomUUID().toString();
        eventPublisher.publish(new TicketCreatedEvent(command.getTenantId(), command.getCategory(), command.getDescription()));
    }

    public void closeTicket(CloseTicketCommand command) {
        eventPublisher.publish(new TicketClosedEvent(command.getTicketId()));
    }

    public void sendReminder(SendReminderCommand command) {
        eventPublisher.publish(new ReminderSentEvent(command.getTicketId()));
    }
}
