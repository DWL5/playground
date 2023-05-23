package com.example.msa_simplemall.service;

import com.example.msa_simplemall.domain.Product;
import com.example.msa_simplemall.domain.ProductChanged;
import com.example.msa_simplemall.dto.ProductRequest;
import com.example.msa_simplemall.kafka.MessageProducer;
import com.example.msa_simplemall.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final MessageProducer messageProducer;

    public ProductCommandService(ProductRepository productRepository, MessageProducer messageProducer) {
        this.productRepository = productRepository;
        this.messageProducer = messageProducer;
    }

    public void create(ProductRequest productRequest) {
        final Product savedProduct = productRepository.save(new Product(productRequest.getName(), productRequest.getStock()));
        ProductChanged productChanged =
                new ProductChanged("ProductChanged", savedProduct.getId(), savedProduct.getName(), savedProduct.getStock());
        messageProducer.sendMessage(productChanged);

    }
}
