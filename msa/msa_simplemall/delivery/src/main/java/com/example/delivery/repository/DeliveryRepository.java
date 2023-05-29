package com.example.delivery.repository;

import com.example.delivery.domain.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
