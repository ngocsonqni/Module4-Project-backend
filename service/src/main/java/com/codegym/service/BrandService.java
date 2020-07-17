package com.codegym.service;

import com.codegym.dao.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();
    boolean createBrand(Brand brand);
<<<<<<< HEAD
    Page<Brand> findAllByNameContaining(Pageable pageable, String search);
=======
    Page<Brand> findAllByBrandNameContaining(Pageable pageable, String search);
>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198
}
