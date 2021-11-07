package com.engeto.springBootProject.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Item {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @Column(unique = true)
    private String name;
    private long amount;

    public Item() {
    }

    public Item(UUID id, String name, long amount) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.name = name;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long quantity) {
        this.amount = quantity;
    }
}
