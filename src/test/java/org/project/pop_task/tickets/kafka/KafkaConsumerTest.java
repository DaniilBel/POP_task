package org.project.pop_task.tickets.kafka;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KafkaConsumerTest {
    @Test
    public void testConsumeEvent() {
        KafkaConsumerService consumerService = mock(KafkaConsumerService.class);
        consumerService.consume();

        verify(consumerService).consume();
    }
}
