package com.codegym.service.impl;

import com.codegym.dao.entity.District;
import com.codegym.dao.repository.location.DistrictRepository;
import com.codegym.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistricServiceImpl implements DistrictService {
    @Autowired
    DistrictRepository distributorRepository;
    @Override
    public List<District> findAllByProvinceId(String id) {
        return distributorRepository.findAllByMatpContaining(id);
    }
}
