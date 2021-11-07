package com.engeto.springBootProject.model.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    private boolean isAdmin;
    @OneToMany(mappedBy = "user")
    private List<BuyingOrder> buyingOrders;

    public User() {
    }

    public User(UUID id, String login, String password, boolean isAdmin) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<BuyingOrder> getOrders() {
        return buyingOrders;
    }

    public void setOrders(List<BuyingOrder> buyingOrders) {
        this.buyingOrders = buyingOrders;
    }
}
