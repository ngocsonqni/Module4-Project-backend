package com.codegym.service;

import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable);
    User findGetId(Long id);
    void save(User user);
    void remove(Long id);
}
