package org.project.pop_task.tickets.handler;

import org.junit.jupiter.api.Test;
import org.project.pop_task.tickets.command.CreateTicketCommand;
import org.project.pop_task.tickets.kafka.KafkaProducerService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicketCommandHandlerTest {
    @Test
    public void testCreateTicketCommand() {
        CreateTicketCommand command = new CreateTicketCommand("Support Issue", "Cannot login to account");
        TicketCommandHandler handler = new TicketCommandHandler();
        handler.handle(command);

        KafkaProducerService producer = mock(KafkaProducerService.class);
        producer.sendEvent("TicketCreated: Support Issue");
        verify(producer).sendEvent("TicketCreated: Support Issue");
    }
}
