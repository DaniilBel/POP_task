package org.project.pop_task.util;

import org.project.pop_task.command.CloseTicketCommand;
import org.project.pop_task.orchestrator.TicketOrchestrator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DeadlineManager {
    private final Map<String, Instant> deadlines = new ConcurrentHashMap<>();
    private final TicketOrchestrator ticketOrchestrator;

    public DeadlineManager(TicketOrchestrator ticketOrchestrator) {
        this.ticketOrchestrator = ticketOrchestrator;
    }

    public void setDeadline(String ticketId, Duration duration) {
        deadlines.put(ticketId, Instant.now().plus(duration));
    }

    public void removeDeadline(String ticketId) {
        deadlines.remove(ticketId);
    }

    @Scheduled(fixedRate = 60000)
    public void checkDeadlines() {
        Instant now = Instant.now();
        deadlines.entrySet().removeIf(entry -> {
            if (entry.getValue().isBefore(now)) {
                ticketOrchestrator.closeTicket(new CloseTicketCommand(entry.getKey()));
                return true;
            }
            return false;
        });
    }
}
