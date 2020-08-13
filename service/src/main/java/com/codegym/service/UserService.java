package com.codegym.service;

import com.codegym.dao.DTO.MemberDTO;
import com.codegym.dao.DTO.UserDTO;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable);

    User findGetId(int id);

    User findUserByAccountName(String accountName);

    void save(User user);

    void save(MemberDTO memberDTO);

    void remove(int id);

    User findUserByAccountId(int accountId);

    Page<User> getAllUser(String name, String birthday, String phone, String email, String value1, String value2, Pageable page);

    Page<UserDTO> getAllUserDto(String name, String birthday, String phone, String email, String value1, String value2, Pageable page);

    List<User> getListAllUser();
}
