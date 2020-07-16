package com.codegym.service;

import com.codegym.dao.entity.Department;

public interface DepartmentService {
    Iterable<Department> findAll();
}
