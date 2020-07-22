package com.codegym.dao.repository;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByDeleteFlagFalse();
    Page<Bill> findAllByDeleteFlagFalse(Pageable pageable);
}
