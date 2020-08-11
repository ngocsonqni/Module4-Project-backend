package com.codegym.service;

import com.codegym.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    List<Employee> findAllDeleted();

    Employee findById(int id);

    Employee findByAccountName(String accountName);

    void save(Employee employee);

    void remove(int id);

    Employee findByAccountId(int accountId);

    Page<Employee> findAllEmployeeWithPage(String key, Pageable pageable);
}
