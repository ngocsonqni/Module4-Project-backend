package com.codegym.service;

import com.codegym.dao.entity.Commune;

import java.util.List;

public interface CommuneService {
    List<Commune> findAllByDistrictId(String id);
    Commune findById(String id);
}
