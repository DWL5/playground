package com.example.product.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    @Value("${message.topic.name}")
    private  String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public EventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendMessage(Object message) {
        String jsonMessage = null;
        try {
            jsonMessage = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        kafkaTemplate.send(topic, jsonMessage);
    }
}
