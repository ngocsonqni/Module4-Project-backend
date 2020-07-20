//package com.codegym.service.Impl;
//
//import com.codegym.dao.entity.Bill;
//import com.codegym.dao.repository.BillRepository;
//import com.codegym.dao.repository.WareHouseRepository;
//import com.codegym.service.BillService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BillServiceImpl implements BillService {
//    @Autowired
//    private BillRepository billRepository;
//
//    @Override
//    public List<Bill> findAllByDeleteFlagFalse() {
//        return billRepository.findAllByDeleteFlagFalse();
//    }
//
//    @Override
//    public Bill findById(Integer id) {
//        return billRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void save(Bill bill) {
//        billRepository.save(bill);
//    }
//
//    @Override
//    public void remove(Bill bill) {
//        bill.setDeletaFlag(true);
//    }
//}