package com.codegym.service.Impl;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Role;
import com.codegym.dao.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        Account account = accountRepository.findAllByAccountName(accountName);
        if (account == null) {
            throw new UsernameNotFoundException("Không thể tìm thấy tên đăng nhập: " + accountName);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role = account.getRoles();
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new org.springframework.security.core.userdetails.User(
                account.getAccountName(),
                account.getAccountPassword(),
                grantedAuthorities);
    }

}
