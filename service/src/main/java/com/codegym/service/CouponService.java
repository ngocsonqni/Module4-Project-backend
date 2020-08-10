package com.codegym.service;

import com.codegym.dao.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface CouponService {
    Page<Coupon> findAllListCoupon(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user);
}
