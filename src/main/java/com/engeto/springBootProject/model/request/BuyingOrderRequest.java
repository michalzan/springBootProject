package com.engeto.springBootProject.model.request;

import com.engeto.springBootProject.model.entity.Item;

import java.util.List;

public class BuyingOrderRequest {

    private List<Item> items;
    private String address;

    public BuyingOrderRequest() {
    }

    public BuyingOrderRequest(List<Item> items, String address) {
        this.items = items;
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
