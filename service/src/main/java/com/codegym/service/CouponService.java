package com.codegym.service;

import com.codegym.dao.entity.Coupon;
import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CouponService {
    Page<Coupon> findAllListCoupon(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user);
    Coupon findById(Integer id);
    void save(Coupon coupon);
}
