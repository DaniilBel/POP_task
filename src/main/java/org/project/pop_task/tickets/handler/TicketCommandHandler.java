package org.project.pop_task.tickets.handler;

import org.project.pop_task.common.command.BaseCommand;
import org.project.pop_task.common.command.CommandHandler;

public class TicketCommandHandler implements CommandHandler {
    @Override
    public void handle(BaseCommand command) {
        command.execute();
    }
}
