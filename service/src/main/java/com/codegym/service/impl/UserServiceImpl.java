package com.codegym.service.impl;

import com.codegym.dao.DTO.MemberDTO;
import com.codegym.dao.DTO.UserDTO;
import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.User;
import com.codegym.dao.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable) {
        return userRepository.findAllByDeleteFlagIsFalse(pageable);
    }

    @Override
    public User findGetId(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByAccountName(String accountName) {
        return userRepository.findByAccount_AccountName(accountName);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void save(MemberDTO memberDTO) {
        User user = new User();
        user.setUserName(memberDTO.getUserName());
        user.setAddress(memberDTO.getAddress());
        user.setBirthday(memberDTO.getBirthday());
        user.setEmail(memberDTO.getEmail());
        user.setGender(memberDTO.getGender());
        user.setPhone(memberDTO.getPhone());
        user.setAccount(memberDTO.getAccount());
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        User currentUser = findGetId(id);
        currentUser.setDeleteFlag(true);
        save(currentUser);
    }

    @Override
    public User findUserByAccountId(int accountId) {
        return userRepository.findAllByDeleteFlagIsFalseAndAccount_AccountId(accountId);
    }

    @Override
    public Page<User> getAllUser(String name, String birthday, String phone, String email, String value1, String value2, Pageable page) {
        return userRepository.getAllUser(name, birthday, phone, email, value1, value2, page);
    }

    @Override
    public Page<UserDTO> getAllUserDto(String name, String birthday, String phone, String email, String value1, String value2, Pageable page) {
        Page<User> userPage = userRepository.getAllUser(name, birthday, phone, email, value1, value2, page);
        List<UserDTO> usersDTO = new ArrayList<>();
        double totalFull = 0;
        for (User user : userPage) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setBirthday(user.getBirthday());
            userDTO.setAddress(user.getAddress());
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setGender(user.getGender());
            userDTO.setImageUrl(user.getImageUrl());
            userDTO.setDeleteFlag(user.getDeleteFlag());
            userDTO.setAccount(user.getAccount());
            userDTO.setListOrder(user.getListOrder());
            for (Order total : user.getListOrder()) {
                totalFull += total.getTotalMoney();
            }
            userDTO.setTotal(totalFull);
            totalFull = 0;
            usersDTO.add(userDTO);
        }
        Page<UserDTO> userDTOPage = new PageImpl<>(usersDTO, page, userPage.getTotalElements());
        return userDTOPage;
    }

    @Override
    public List<User> getListAllUser() {
        return userRepository.findAll();
    }
}
