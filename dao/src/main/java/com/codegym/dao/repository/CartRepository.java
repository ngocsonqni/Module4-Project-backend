package com.codegym.dao.repository;

import com.codegym.dao.entity.Cart;
import com.codegym.dao.entity.CartPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartPk> {

}
