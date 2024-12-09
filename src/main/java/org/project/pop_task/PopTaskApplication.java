package org.project.pop_task;

import org.project.pop_task.command.AssignAgentCommand;
import org.project.pop_task.command.CreateTicketCommand;
import org.project.pop_task.service.TicketService;
import org.project.pop_task.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PopTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopTaskApplication.class, args);

    }

}
