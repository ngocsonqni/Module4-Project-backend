package com.codegym.service.Impl;

import com.codegym.dao.entity.Coupon;
import com.codegym.dao.entity.CouponCreate;
import com.codegym.dao.repository.CouponHuylmRepositoty;
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

    @Autowired
    private CouponHuylmRepositoty couponHuylmRepositoty;

    @Override
    public Page<Coupon> findAllListCoupon(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user) {
        return couponRepository.findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameAndUser_UserNameAndDeleteFlagFalse(pageable, createDateFrom, createDateTo, employee, user);
    }

    @Override
    public void save(CouponCreate coupon) {
        couponHuylmRepositoty.save(coupon);
    }
    public Page<Coupon> findAllListCouponWithEmployee(Pageable pageable, Date createDateFrom, Date createDateTo, String employee) {
        return couponRepository.findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameAndDeleteFlagFalse(pageable, createDateFrom, createDateTo, employee);
    }

    @Override
    public Page<Coupon> findAllListCouponWithUser(Pageable pageable, Date createDateFrom, Date createDateTo, String user) {
        return couponRepository.findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndUser_UserNameAndDeleteFlagFalse(pageable, createDateFrom, createDateTo, user);
    }

    @Override
    public Page<Coupon> findAllListCouponWithBlank(Pageable pageable, Date createDateFrom, Date createDateTo) {
        return couponRepository.findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndDeleteFlagFalse(pageable, createDateFrom, createDateTo);
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
