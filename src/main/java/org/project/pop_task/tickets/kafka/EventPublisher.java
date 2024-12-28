package org.project.pop_task.tickets.kafka;

public class EventPublisher {
    private static final KafkaProducerService producer = new KafkaProducerService("ticket-events");

    public static void publish(String eventMessage) {
        producer.sendEvent(eventMessage);
    }

    public static void close() {
        producer.close();
    }
}
