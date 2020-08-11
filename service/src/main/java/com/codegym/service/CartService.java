package com.codegym.service;

import com.codegym.dao.entity.Cart;
import com.codegym.dao.entity.CartPk;

import java.util.Optional;

public interface CartService {
    Optional<Cart> findById(CartPk cartPk);
    void save(Cart cart);
    void delete(Cart cart);
}
