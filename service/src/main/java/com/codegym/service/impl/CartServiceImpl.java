package com.codegym.service.impl;

import com.codegym.dao.entity.Cart;
import com.codegym.dao.entity.CartPk;
import com.codegym.dao.repository.CartRepository;
import com.codegym.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Optional<Cart> findById(CartPk cartPk) {
        return this.cartRepository.findById(cartPk);
    }

    @Override
    public void save(Cart cart) {
        this.cartRepository.save(cart);
    }
}
