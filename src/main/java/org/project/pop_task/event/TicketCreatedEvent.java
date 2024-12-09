package org.project.pop_task.event;

import java.time.LocalDateTime;

public class TicketCreatedEvent {
    private final int ticketId;
    private final String category;
    private final String description;
    private final int tenantId;
    private final LocalDateTime createdAt;

    public TicketCreatedEvent(int ticketId, String category, String description, int tenantId) {
        this.ticketId = ticketId;
        this.category = category;
        this.description = description;
        this.tenantId = tenantId;
        this.createdAt = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getTenantId() {
        return tenantId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "TicketCreatedEvent{" +
                "ticketId=" + ticketId +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", tenantId=" + tenantId +
                ", createdAt=" + createdAt +
                '}';
    }
}
