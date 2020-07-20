package com.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import com.codegym.dao.entity.Brand;

public interface BrandService {
    List<Brand> getAllBrand();
    boolean createBrand(Brand brand);
    Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search);
    Brand findById(Integer id);
    void save(Brand brand);
    void delete(Brand brand);
}
