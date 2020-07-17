package com.codegym.service.Impl;

import com.codegym.dao.entity.Brand;
import com.codegym.dao.repository.BrandRepository;
import com.codegym.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
<<<<<<< HEAD
    public List<Brand> getAllBrand() {
=======
    public List<Brand> getAllBrand( ) {
>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198
        return brandRepository.findAllByDeleteFlagFalse();
    }

    @Override
    public boolean createBrand(Brand brand) {
        List<Brand> brandList = brandRepository.findAllByDeleteFlagFalse();
        for (Brand brand1 : brandList) {
            if (brand.getBrandName().equals(brand1.getBrandName())) {
                return false;
            }
        }
        brandRepository.save(brand);
        return true;
    }

    @Override
<<<<<<< HEAD
    public Page<Brand> findAllByNameContaining(Pageable pageable, String search) {
        return brandRepository.findAllByBrandNameContaining(pageable, search);
=======
    public Page<Brand> findAllByBrandNameContaining(Pageable pageable, String search) {
        return brandRepository.findAllByBrandNameContaining(pageable,search);
>>>>>>> 5fcf850802259f604d5893956cd1e663f9566198
    }
}
