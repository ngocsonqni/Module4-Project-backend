package com.codegym.service;

import com.codegym.dao.entity.role;

import java.util.List;

public interface roleService {
    List<role> findAllRole();

    role findRoleById(int id);
}
