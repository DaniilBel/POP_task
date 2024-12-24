package org.project.pop_task.util;

import org.junit.jupiter.api.Test;
import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.orchestrator.TicketOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DeadlineManagerTest {
    @Autowired
    private DeadlineManager deadlineManager;

    @MockBean
    private TicketOrchestrator ticketOrchestrator;

    @Test
    public void testDeadlineTrigger() throws InterruptedException {
        deadlineManager.setDeadline("ticket123", Duration.ofSeconds(1));
        try {
            Thread.sleep(2000); // Wait for the deadline to expire
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Manually invoke the deadline check
        deadlineManager.checkDeadlines();

        // Verify that closeTicket was called
        verify(ticketOrchestrator, times(1)).closeTicket(any(CloseTicketCommand.class));
    }

    @Test
    public void testRemoveDeadline() {
        // Arrange
        String ticketId = "ticket123";
        Duration duration = Duration.ofSeconds(1);

        // Act
        deadlineManager.setDeadline(ticketId, duration); // First, set a deadline
        deadlineManager.removeDeadline(ticketId); // Then, remove it

        // Wait for the duration to ensure no actions occur after the deadline
        try {
            Thread.sleep(2000); // Sleep for more than the deadline duration
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Assert
        // Verify that no attempt was made to close the ticket after the deadline expired
        verify(ticketOrchestrator, times(0)).closeTicket(any(CloseTicketCommand.class));
    }
}
