package com.codegym.service;

import com.codegym.dao.DTO.AccountDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AccountService {
    UserDetails loadAccountByAccountName(String accountName);
//    UserDetails loadUserByUsername(String accountName);
    List<AccountDTO> findAll();
}
