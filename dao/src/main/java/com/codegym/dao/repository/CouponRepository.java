package com.codegym.dao.repository;

import com.codegym.dao.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Page<Coupon> findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameContainingAndUser_UserNameContainingAndDeleteFlagFalse(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user);

    //---------------------- Hieu Nguyen ---------------------------------
    Coupon findByCouponIdAndDeleteFlagFalse (Integer id);
}
