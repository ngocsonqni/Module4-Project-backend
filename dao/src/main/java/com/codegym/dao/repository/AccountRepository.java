package com.codegym.dao.repository;

import com.codegym.dao.entity.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findAllByAccountName(String account);
}
