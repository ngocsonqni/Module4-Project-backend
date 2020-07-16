package com.codegym.service;

import com.codegym.dao.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();

    Account findAccountById(int id);

    void save(Account account);

    Account findAccountByName(String name);
}
