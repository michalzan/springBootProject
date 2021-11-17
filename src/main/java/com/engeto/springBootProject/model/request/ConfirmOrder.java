package com.engeto.springBootProject.model.request;

import java.util.UUID;

public class ConfirmOrder {

    private UUID orderId;

    public ConfirmOrder() {
    }

    public ConfirmOrder(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
