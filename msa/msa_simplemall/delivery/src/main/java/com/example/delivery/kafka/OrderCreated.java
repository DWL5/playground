package com.example.delivery.kafka;

public class OrderCreated {
    private Long id;
    private Long productId;
    private String productName;
    private Long userId;
    private int qty;
    private int price;

    public OrderCreated(Long id, Long productId, String productName, Long userId, int qty, int price) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.userId = userId;
        this.qty = qty;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
