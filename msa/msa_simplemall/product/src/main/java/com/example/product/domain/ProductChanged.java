package com.example.product.domain;


import lombok.Getter;

@Getter
public class ProductChanged {
    private String eventType;
    private Long productId;
    private String productName;
    private int productStock;

    public ProductChanged(String eventType, Long productId, String productName, int productStock) {
        this.eventType = eventType;
        this.productId = productId;
        this.productName = productName;
        this.productStock = productStock;
    }
}
