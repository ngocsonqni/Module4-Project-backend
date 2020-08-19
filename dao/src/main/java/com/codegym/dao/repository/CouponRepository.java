package com.codegym.dao.repository;

import com.codegym.dao.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Page<Coupon> findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameAndUser_UserNameAndDeleteFlagFalse(Pageable pageable, Date createDateFrom, Date createDateTo, String employee, String user);

    Page<Coupon> findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndEmployee_NameAndDeleteFlagFalse(Pageable pageable, Date createDateFrom, Date createDateTo, String employee);

    Page<Coupon> findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndUser_UserNameAndDeleteFlagFalse(Pageable pageable, Date createDateFrom, Date createDateTo, String user);

    Page<Coupon> findAllByCreateDateIsGreaterThanEqualAndCreateDateIsLessThanEqualAndDeleteFlagFalse(Pageable pageable, Date createDateFrom, Date createDateTo);

    //---------------------- Hieu Nguyen ---------------------------------
    Coupon findByCouponIdAndDeleteFlagFalse(Integer id);
}
