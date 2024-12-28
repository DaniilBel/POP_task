package org.project.pop_task.tickets.event;

import org.project.pop_task.common.event.BaseEvent;

public class TicketClosedEvent extends BaseEvent {

    private final Long ticketId;

    public TicketClosedEvent(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketId() {
        return ticketId;
    }
}
