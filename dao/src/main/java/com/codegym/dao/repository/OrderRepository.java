package com.codegym.dao.repository;

import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "select u from Order u where u.user.id_user=?1")
    Page<Order> findAllByIdUser(Integer id, Pageable pageable);
}
