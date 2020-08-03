package com.codegym.service;

import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable);

    User findGetId(int id);

    User findUserByAccountName(String accountName);

    void save(User user);

    void remove(int id);

    User findUserByAccountId(int accountId);
    Page<User> getAllUser(String name, String birthday, String phone, String email, String value1, String value2, Pageable page);
}
