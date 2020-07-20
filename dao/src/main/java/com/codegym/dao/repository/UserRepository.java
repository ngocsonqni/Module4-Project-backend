package com.codegym.dao.repository;

import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findAllByDeleteFlagIsFalse(Pageable pageable);
    User findByAccount_AccountName(String accountName);
}
