package org.project.pop_task;

import org.project.pop_task.command.AssignAgentCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.service.TicketService;
import org.project.pop_task.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class PopTaskApplication {

    public static void main(String[] args) {
//        SpringApplication.run(PopTaskApplication.class, args);
        TicketService ticketService = new TicketService();

        User agent1 = new User("AGENT1", "Alice", "Agent");
        User agent2 = new User("AGENT2", "Bob", "Agent");

        ticketService.registerUser(agent1);
        ticketService.registerUser(agent2);

        // Создаем тикет
        CreateTicketCommand createTicketCommand = new CreateTicketCommand("Bug", "System crashes on login", "TENANT1");
        ticketService.handleCreateTicket(createTicketCommand);

        // Назначаем агента на тикет
        AssignAgentCommand assignAgentCommand = new AssignAgentCommand("TICKET-1", "AGENT1");
        ticketService.handleAssignAgent(assignAgentCommand);
    }

}
