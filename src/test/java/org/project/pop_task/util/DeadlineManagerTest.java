package org.project.pop_task.util;

import org.junit.jupiter.api.Test;
import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.orchestrator.TicketOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeadlineManagerTest {
    @Autowired
    private DeadlineManager deadlineManager;

    @MockBean
    private TicketOrchestrator ticketOrchestrator;

    @Test
    public void testDeadlineTrigger() {
        deadlineManager.setDeadline("ticket123", Duration.ofSeconds(1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        deadlineManager.checkDeadlines();

        verify(ticketOrchestrator, times(1)).closeTicket(any(CloseTicketCommand.class));
    }

    @Test
    public void testRemoveDeadline() {
        String ticketId = "ticket123";
        Duration duration = Duration.ofSeconds(1);

        deadlineManager.setDeadline(ticketId, duration);
        deadlineManager.removeDeadline(ticketId);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        verify(ticketOrchestrator, times(0)).closeTicket(any(CloseTicketCommand.class));
    }
}
