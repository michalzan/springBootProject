package com.engeto.springBootProject.model.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class BuyingOrder {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "buying_order_buying_order_item",
            joinColumns = { @JoinColumn(name = "buying_order_id") },
            inverseJoinColumns = { @JoinColumn(name = "buying_order_item_id") }
    )
    private List<BuyingOrderItem> items = new ArrayList<>();

    private boolean pending;

    public BuyingOrder() {
    }

    public BuyingOrder(UUID id, String address, List<BuyingOrderItem> items, boolean pending) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.items = items;
        this.address = address;
        this.pending = pending;
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BuyingOrderItem> getItems() {
        return items;
    }

    public void setItems(List<BuyingOrderItem> items) {
        this.items = items;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }
}
