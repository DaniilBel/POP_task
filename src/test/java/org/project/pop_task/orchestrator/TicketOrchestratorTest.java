package org.project.pop_task.orchestrator;

import org.junit.jupiter.api.Test;
import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.command.SendReminderCommand;
import org.project.pop_task.event.ReminderSentEvent;
import org.project.pop_task.event.TicketClosedEvent;
import org.project.pop_task.event.TicketCreatedEvent;
import org.project.pop_task.publisher.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {TicketOrchestrator.class, EventPublisher.class})
public class TicketOrchestratorTest {
    @Autowired
    private TicketOrchestrator ticketOrchestrator;

    @MockBean
    private EventPublisher eventPublisher;

    @Test
    public void contextLoads() {
        assertNotNull(ticketOrchestrator, "TicketOrchestrator should not be null");
    }

    @Test
    public void testCreateTicket() {
        String category = "Support";
        String description = "Issue description";
        String ticketId = "ticket123";

        CreateTicketCommand command = new CreateTicketCommand(category, description, ticketId);
        ticketOrchestrator.createTicket(command);

        verify(eventPublisher).publish(argThat(event ->
                event instanceof TicketCreatedEvent &&
                        category.equals(((TicketCreatedEvent) event).getCategory()) &&
                        description.equals(((TicketCreatedEvent) event).getDescription()) &&
                        ticketId.equals(((TicketCreatedEvent) event).getTicketId())
        ));
    }

    @Test
    public void testCloseTicket() {
        CloseTicketCommand command = new CloseTicketCommand("ticket123");
        ticketOrchestrator.closeTicket(command);

        verify(eventPublisher).publish(argThat(event ->
                event instanceof TicketClosedEvent &&
                        "ticket123".equals(((TicketClosedEvent) event).getTicketId())
        ));
    }

    @Test
    public void testSendReminder() {
        SendReminderCommand command = new SendReminderCommand("ticket123");
        ReminderSentEvent expectedEvent = new ReminderSentEvent("ticket123");

        ticketOrchestrator.sendReminder(command);

        verify(eventPublisher, times(1)).publish(argThat(event ->
                event instanceof ReminderSentEvent &&
                        ((ReminderSentEvent) event).getTicketId().equals(expectedEvent.getTicketId())
        ));
    }
}
