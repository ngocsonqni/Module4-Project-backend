package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class CartPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "users")
    @JsonBackReference(value = "user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    public CartPk() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User id_user) {
        this.user = id_user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product_id) {
        this.product = product_id;
    }
}
