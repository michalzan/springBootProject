package com.engeto.springBootProject.model.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class BuyingOrderItem {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    private Item item;
    private long amount;

    public BuyingOrderItem() {
    }

    public BuyingOrderItem(UUID id, Item item, long amount) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.item = item;
        this.amount = amount;
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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
