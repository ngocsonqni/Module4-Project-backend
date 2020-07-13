package com.codegym.service.Impl;

import com.codegym.dao.entity.role;
import com.codegym.dao.repository.roleRepository;
import com.codegym.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class roleServiceImpl implements roleService {
    @Autowired
    private com.codegym.dao.repository.roleRepository roleRepository;

    @Override
    public List<role> findAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public role findRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }
}
