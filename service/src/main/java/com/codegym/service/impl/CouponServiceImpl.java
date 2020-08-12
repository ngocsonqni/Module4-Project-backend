package com.codegym.service.impl;

import com.codegym.dao.entity.Coupon;
import com.codegym.dao.repository.CouponRepository;
import com.codegym.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public Page<Coupon> findAllListCoupon(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user) {
        return couponRepository.findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameContainingAndUser_UserNameContainingAndDeleteFlagFalse(pageable, createDateFrom, createDateTo, employee, user);
    }

    //---------------------- Hieu Nguyen Service Impl ---------------------------------
    @Override
    public Coupon findById(Integer id) {
        return couponRepository.findByCouponIdAndDeleteFlagFalse(id);
    }

    @Override
    public void save(Coupon coupon) {
        couponRepository.save(coupon);
    }

    @Override
    public void remove(Coupon coupon) {
        coupon.setDeleteFlag(true);
    }
    //---------------------- Hieu Nguyen Service Impl - END ---------------------------------
}
