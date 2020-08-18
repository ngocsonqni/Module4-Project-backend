package com.codegym.service;

import com.codegym.dao.entity.Province;

import java.util.List;

public interface ProvinceService {
     List<Province> findAll();
     Province findById(String id);
     Province findByName(String name);
}

