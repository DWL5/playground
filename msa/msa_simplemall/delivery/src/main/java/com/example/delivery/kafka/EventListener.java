package com.example.delivery.kafka;

import com.example.delivery.dto.DeliveryCreateCommand;
import com.example.delivery.service.DeliveryCommandService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventListener {
    private static final String TOPIC = "";
    private final DeliveryCommandService deliveryCommandService;

    public EventListener(DeliveryCommandService deliveryCommandService) {
        this.deliveryCommandService = deliveryCommandService;
    }

    @KafkaListener(topics = TOPIC)
    public void consume(OrderCreated message) {
        deliveryCommandService.create(new DeliveryCreateCommand(message.getId(), message.getProductId(),
                message.getProductName(), message.getUserId()));
    }

}
