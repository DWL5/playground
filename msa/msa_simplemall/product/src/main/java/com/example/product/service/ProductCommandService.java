package com.example.product.service;

import com.example.product.domain.Product;
import com.example.product.domain.ProductChanged;
import com.example.product.dto.ProductRequest;
import com.example.product.kafka.EventPublisher;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final EventPublisher eventPublisher;

    public ProductCommandService(ProductRepository productRepository, EventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    public void create(ProductRequest productRequest) {
        final Product savedProduct = productRepository.save(new Product(productRequest.getName(), productRequest.getStock()));
        ProductChanged productChanged =
                new ProductChanged("ProductChanged", savedProduct.getId(), savedProduct.getName(), savedProduct.getStock());
        eventPublisher.sendMessage(productChanged);

    }
}
