package com.engeto.springBootProject.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class BuyingOrderRequest {

    @Size(min = 1)
    private List<OrderItem> items;

    @NotBlank
    @NotEmpty
    private String address;

    public BuyingOrderRequest() {
    }

    public BuyingOrderRequest(List<OrderItem> items, String address) {
        this.items = items;
        this.address = address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
