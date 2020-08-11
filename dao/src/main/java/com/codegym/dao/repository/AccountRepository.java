package com.codegym.dao.repository;

import com.codegym.dao.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findAllByDeleteFlagIsFalse();

    Account findAccountByAccountIdAndDeleteFlagIsFalse(int id);

    Account findAccountByDeleteFlagIsFalseAndAccountName(String name);

    Page<Account> findAllByAccountNameContainingAndRole_RoleNameContainingAndDeleteFlagIsFalse(String userName, String role, Pageable pageable);

    Page<Account> findAllByRole_RoleNameAndDeleteFlagIsFalse(String rolename, Pageable pageable);

    Account findAllByAccountName(String name);

    @Query(value = "select * from account\n" +
            "where account.account_id not in (\n" +
            "select account.account_id\n" +
            "from account\n" +
            "inner join employee on employee.account_id = account.account_id\n" +
            ")", nativeQuery = true)
    List<Account> findAllAccountNotInEmployee();
}
