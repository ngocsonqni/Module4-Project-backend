package com.codegym.dao.repository;

import com.codegym.dao.entity.CouponCreate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponHuylmRepositoty extends JpaRepository<CouponCreate, Integer> {
}
