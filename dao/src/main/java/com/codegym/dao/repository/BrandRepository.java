package com.codegym.dao.repository;

import com.codegym.dao.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
<<<<<<< HEAD
    List<Brand> findAllByDeleteFlagFalse();
    Page<Brand> findAllByBrandNameContaining(Pageable pageable, String name);
}
=======
  List<Brand> findAllByDeleteFlagFalse();
  Page<Brand> findAllByBrandNameContaining(Pageable pageable, String name);
}
>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198
