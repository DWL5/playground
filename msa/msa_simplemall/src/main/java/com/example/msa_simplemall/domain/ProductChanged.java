package com.example.msa_simplemall.domain;


import lombok.Getter;
import lombok.Setter;

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
