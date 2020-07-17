package com.codegym.service;

import com.codegym.dao.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAllByDeleteFlagFalse();
    Brand findById(Integer id);
    void save(Brand brand);
    void delete(Brand brand);
}
