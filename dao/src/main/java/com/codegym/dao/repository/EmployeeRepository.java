package com.codegym.dao.repository;

import com.codegym.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDeleteFlagIsFalse();

    List<Employee> findAllByDeleteFlagIsTrue();

    Employee findByDeleteFlagIsFalseAndId(Integer id);

    Employee findByAccount_AccountIdAndDeleteFlagIsFalse(int accountId);
}
