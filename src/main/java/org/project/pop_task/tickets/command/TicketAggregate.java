package org.project.pop_task.tickets.command;

import lombok.Getter;
import lombok.Setter;
import org.project.pop_task.common.event.EventPublisher;
import org.project.pop_task.tickets.event.TicketClosedEvent;

public class TicketAggregate {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String description;
    private boolean isClosed;

    public TicketAggregate(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isClosed = false;
    }

    public void closeTicket() {
        if (isClosed) {
            throw new IllegalStateException("Ticket is already closed.");
        }
        this.isClosed = true;
        EventPublisher.publish(new TicketClosedEvent(this.id));
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
