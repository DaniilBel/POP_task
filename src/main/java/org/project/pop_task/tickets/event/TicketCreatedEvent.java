package org.project.pop_task.tickets.event;

import org.project.pop_task.common.event.BaseEvent;

public class TicketCreatedEvent extends BaseEvent {

    private final String title;
    private final String description;

    public TicketCreatedEvent(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
