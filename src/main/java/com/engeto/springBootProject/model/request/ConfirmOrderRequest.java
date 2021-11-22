package com.engeto.springBootProject.model.request;

import java.util.UUID;

public class ConfirmOrderRequest {

    private UUID orderId;

    public ConfirmOrderRequest() {
    }

    public ConfirmOrderRequest(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}
