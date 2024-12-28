package org.project.pop_task.tickets.command;

import org.project.pop_task.common.command.BaseCommand;
import org.project.pop_task.common.event.EventPublisher;
import org.project.pop_task.tickets.event.TicketCreatedEvent;
import org.project.pop_task.tickets.query.TicketRepository;

public class CreateTicketCommand implements BaseCommand {
    private final String title;
    private final String description;
    private static Long id = 0L;

    public CreateTicketCommand(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public void execute() {
        System.out.println("Creating ticket...");
        TicketAggregate ticket = new TicketAggregate(++id, title, description);
        TicketRepository.save(new TicketAggregate(id, title, description));
        EventPublisher.publish(new TicketCreatedEvent(ticket.getTitle(), ticket.getDescription()));
    }
}
