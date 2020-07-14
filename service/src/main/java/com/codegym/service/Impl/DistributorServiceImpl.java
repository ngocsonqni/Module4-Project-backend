package com.codegym.service.Impl;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.repository.DistributorRepository;
import com.codegym.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
 public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    @Override
    public Distributor findById(int id) {
        return distributorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Distributor distributor) {
        distributorRepository.save(distributor);
    }




}
