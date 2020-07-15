package com.codegym.service.Impl;

import com.codegym.dao.entity.Brand;
import com.codegym.dao.repository.BrandRepository;
import com.codegym.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAllByDeleteFlagFalse() {
        return brandRepository.findAllByDeleteFlagFalse();
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Brand brand) {
        brand.setDeleteFlag(true);
    }
}
