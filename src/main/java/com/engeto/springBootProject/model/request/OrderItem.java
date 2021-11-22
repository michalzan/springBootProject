package com.engeto.springBootProject.model.request;

public class OrderItem {
    private String itemName;
    private Long amount;

    public OrderItem() {
    }

    public OrderItem(String itemName, Long amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
