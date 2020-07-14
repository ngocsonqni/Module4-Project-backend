package com.codegym.service.Impl;

import com.codegym.dao.entity.Employee;
import com.codegym.dao.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public List<Employee> findAllDeleted() {
        return employeeRepository.findAllByDeleteFlagIsTrue();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findByDeleteFlagIsFalseAndId(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        Employee employee = employeeRepository.findByDeleteFlagIsFalseAndId(id);
        employee.setDeleteFlag(true);
    }
}
