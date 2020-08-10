package com.codegym.service;

import com.codegym.dao.entity.District;

import java.util.List;

public interface DistrictService {

    public List<District> findAllByProvinceId(String id);
    District findById(String id);

}
