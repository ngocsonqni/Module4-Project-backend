package com.codegym.service.Impl;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.repository.DistributorRepository;
import com.codegym.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Distributor> findAll() {
        return distributorRepository.findAll();
    }

    @Override
    public Page<Distributor> pageFindAllSearchName(Pageable pageable, String search) {
        Page<Distributor> distributorPage = distributorRepository.findAllByNameContaining(pageable, search);
        return distributorPage;
    }
}
