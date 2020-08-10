package com.codegym.service;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Brand;
import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BillService {
    Page<Bill> findAllByDeleteFlagFalsePaging(Pageable pageable);
    List<Bill> findAllByDeleteFlagFalse();
    Bill findById(Integer id);
    void save(Bill bill);
    void remove(Bill bill);
    boolean createBill(Bill bill);
    List<Bill> findAllByIdDistributorAndShippingStatusIsNot(Distributor distributor, String status);
    List<Bill> findAllBillByDistributorId(int id);
}
