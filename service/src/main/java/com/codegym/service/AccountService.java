package com.codegym.service;

import com.codegym.dao.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();

    Account findAccountById(int id);

    void save(Account account);

    Page<Account> pageFindALLSearchNameOfCourseOfAdmin(Pageable pageable, String search);
}
