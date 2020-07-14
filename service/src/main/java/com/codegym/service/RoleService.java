package com.codegym.service;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();

    Role findRoleById(int id);
}
