package org.project.pop_task.tickets.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerService {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaProducerService(String topic) {
        this.topic = String.valueOf(topic);
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(properties);
    }

    public void sendEvent(String eventMessage) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "key", eventMessage);
        producer.send(record);
        System.out.println("Event sent: " + eventMessage);
    }

    public void close() {
        producer.close();
    }
}
