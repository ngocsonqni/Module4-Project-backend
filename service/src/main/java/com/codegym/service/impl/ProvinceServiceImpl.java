package com.codegym.service.impl;

import com.codegym.dao.entity.Province;
import com.codegym.dao.repository.location.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(String id) {
        return this.provinceRepository.findById(id).orElse(null);
    }

    @Override
    public Province findByName(String name) {
        return this.provinceRepository.findByName(name);
    }
}
