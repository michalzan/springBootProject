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

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private List<Item> items = new ArrayList<>();

    private boolean pending;

    public BuyingOrder() {
    }

    public BuyingOrder(UUID id, User user, List<Item> items, boolean pending) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.user = user;
        this.items = items;
        this.pending = pending;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }
}
