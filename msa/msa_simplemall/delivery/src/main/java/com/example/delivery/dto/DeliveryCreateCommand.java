package com.example.delivery.dto;

public class DeliveryCreateCommand {
    private Long orderId;
    private Long productId;
    private String productName;
    private Long userId;

    public DeliveryCreateCommand(Long orderId, Long productId, String productName, Long userId) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}
