package com.example.delivery.service;

import com.example.delivery.domain.Delivery;
import com.example.delivery.dto.DeliveryCreateCommand;
import com.example.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryCommandService {
    private final DeliveryRepository deliveryRepository;


    public DeliveryCommandService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void create(DeliveryCreateCommand command) {
        Delivery delivery = new Delivery(command.getOrderId(), command.getProductId(), command.getProductName(), command.getUserId());
        deliveryRepository.save(delivery);
    }
}
