package com.codegym.service.Impl;

import com.codegym.dao.entity.Department;
import com.codegym.dao.repository.DepartmentRepository;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }
}
