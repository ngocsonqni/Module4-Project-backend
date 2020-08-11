package com.codegym.service.impl;

import com.codegym.dao.entity.Commune;
import com.codegym.dao.repository.location.CommuneRepository;
import com.codegym.service.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommuneServiceImpl implements CommuneService {

    @Autowired
    CommuneRepository communeRepository;



    @Override
    public List<Commune> findAllByDistrictId(String id) {
        return communeRepository.findAllByMaqhContaining(id);
    }

    @Override
    public Commune findById(String id) {
        return this.communeRepository.findById(id).orElse(null);
    }
}
