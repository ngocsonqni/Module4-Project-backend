package com.codegym.service;

import com.codegym.dao.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findAllDeleted();
    Employee findById(int id);
    void save(Employee employee);
    void remove(int id);
}