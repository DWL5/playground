package com.example.product.controller;

import com.example.product.dto.ProductRequest;
import com.example.product.service.ProductCommandService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductCommandService productCommandService;

    public ProductController(ProductCommandService productCommandService) {
        this.productCommandService = productCommandService;
    }

    @GetMapping("/{productId}")
    public void read(@PathVariable Long productId) {
    }

    @PostMapping
    public void create(@RequestBody ProductRequest productRequest) {
        productCommandService.create(productRequest);

    }

    @PatchMapping
    public void update(ProductRequest productRequest) {

    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable Long productId) {

    }
}
