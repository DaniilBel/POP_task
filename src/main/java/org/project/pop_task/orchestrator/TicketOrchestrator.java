package org.project.pop_task.orchestrator;

import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.command.SendReminderCommand;
import org.project.pop_task.event.ReminderSentEvent;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.publisher.EventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TicketOrchestrator {
    private final EventPublisher eventPublisher;

    public TicketOrchestrator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void createTicket(CreateTicketCommand command) {
        eventPublisher.publish(new TicketCreatedEvent(command.getTenantId(), command.getCategory(), command.getDescription()));
    }

    public void closeTicket(CloseTicketCommand command) {
        eventPublisher.publish(new TicketClosedEvent(command.getTicketId()));
    }

    public void sendReminder(SendReminderCommand command) {
        eventPublisher.publish(new ReminderSentEvent(command.getTicketId()));
    }
}
