package com.codegym.service;

import com.codegym.dao.entity.District;

import java.util.List;

public interface DistrictService {

    public List<District> findAllByProvinceId(String id);
    District findByName(String name);

    District findById(String id);
}
