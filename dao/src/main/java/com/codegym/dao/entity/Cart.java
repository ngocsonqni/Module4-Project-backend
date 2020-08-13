package com.codegym.dao.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @EmbeddedId
    private CartPk id;
    @Column(name = "quantity")
    private int quantity;

    public Cart() {
    }

    public CartPk getId() {
        return id;
    }

    public void setId(CartPk id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
