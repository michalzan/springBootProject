package com.engeto.springBootProject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class BuyingOrderItem {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    private Item item;

    @ManyToOne
    @JsonIgnore
    private BuyingOrder order;

    private long orderAmount;

    public BuyingOrderItem() {
    }

    public BuyingOrderItem(UUID id, Item item, BuyingOrder order, long orderAmount) {
        this.id = id;
        this.item = item;
        this.order = order;
        this.orderAmount = orderAmount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BuyingOrder getOrder() {
        return order;
    }

    public void setOrder(BuyingOrder order) {
        this.order = order;
    }

    public long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(long amount) {
        this.orderAmount = amount;
    }
}
