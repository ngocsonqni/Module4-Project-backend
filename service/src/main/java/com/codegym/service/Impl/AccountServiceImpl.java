package com.codegym.service.Impl;

import com.codegym.dao.entity.Account;
import com.codegym.dao.repository.AccountRepository;
import com.codegym.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountByAccountIdAndDeleteFlagIsFalse(id);
    }
}
