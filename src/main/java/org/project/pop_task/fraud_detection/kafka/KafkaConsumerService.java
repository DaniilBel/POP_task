package org.project.pop_task.fraud_detection.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerService {
    private final KafkaConsumer<String, String> consumer;

    public KafkaConsumerService(String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "ticket-service-group");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topic));
    }

    public void consume() {
        consumer.poll(100).forEach(record -> {
            System.out.println("Received event: " + record.value());
        });
    }
}
