package com.codegym.service;

import com.codegym.dao.DTO.MemberDTO;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable);

    User findGetId(int id);

    User findUserByAccountName(String accountName);

    void save(User user);
    void save(MemberDTO memberDTO);

    void remove(int id);

    User findUserByAccountId(int accountId);
}
