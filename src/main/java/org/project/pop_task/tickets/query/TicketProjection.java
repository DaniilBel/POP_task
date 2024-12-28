package org.project.pop_task.tickets.query;

import lombok.Getter;
import org.project.pop_task.tickets.command.TicketAggregate;

public class TicketProjection {
    @Getter
    private final Long id;
    @Getter
    private final String title;
    @Getter
    private final String description;
    private final boolean isClosed;

    private TicketProjection(Long id, String title, String description, boolean isClosed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isClosed = isClosed;
    }

    public static TicketProjection fromAggregate(TicketAggregate aggregate) {
        return new TicketProjection(
                aggregate.getId(),
                aggregate.getTitle(),
                aggregate.getDescription(),
                aggregate.isClosed()
        );
    }

    public boolean isClosed() {
        return isClosed;
    }
}
