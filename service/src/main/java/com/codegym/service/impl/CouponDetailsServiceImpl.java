package com.codegym.service.Impl;

import com.codegym.dao.entity.CouponDetails;
import com.codegym.dao.repository.CouponDetailsRepository;
import com.codegym.service.CouponDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponDetailsServiceImpl implements CouponDetailsService {

    @Autowired
    CouponDetailsRepository couponDetailsRepository;

    @Override
    public void save(CouponDetails couponDetails) {
        couponDetailsRepository.save(couponDetails);
    }
}
