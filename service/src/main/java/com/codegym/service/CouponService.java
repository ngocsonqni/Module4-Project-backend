package com.codegym.service;

import com.codegym.dao.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface CouponService {
    Page<Coupon> findAllListCoupon(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user);

    Page<Coupon> findAllListCouponWithEmployee(Pageable pageable, Date createDateFrom, Date createDateTo, String employee);

    Page<Coupon> findAllListCouponWithUser(Pageable pageable, Date createDateFrom, Date createDateTo, String user);

    Page<Coupon> findAllListCouponWithBlank(Pageable pageable, Date createDateFrom, Date createDateTo);

    //---------------------- Hieu Nguyen Service ---------------------------------
    Coupon findById(Integer id);

    void save(Coupon coupon);

    void remove(Coupon coupon);
    //---------------------- Hieu Nguyen Service - END ---------------------------------
}
