package com.codegym.service;


import com.codegym.dao.DTO.AccountDTO;
import com.codegym.dao.DTO.MemberDTO;
import org.springframework.security.core.userdetails.UserDetails;
import com.codegym.dao.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AccountService {
    UserDetails loadAccountByAccountName(String accountName);

    List<AccountDTO> findAll();

    List<Account> findAllAccount();

    Account findAccountById(int id);

    void save(MemberDTO memberDTO);

    void save(Account account);

    Account findAccountByName(String name);

    Page<Account> pageFindALLSearchNameOfCourseOfAdmin(Pageable pageable,String nameRole, String search);

    Page<Account> pageFindALLSearchRoleOfCourseOfAdmin(Pageable pageable, String search);

}
