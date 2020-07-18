package com.codegym.service;

import com.codegym.dao.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrand();
    boolean createBrand(Brand brand);
    Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search);

}
