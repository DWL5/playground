package com.example.msa_simplemall.controller;

import com.example.msa_simplemall.dto.ProductRequest;
import com.example.msa_simplemall.service.ProductCommandService;
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
