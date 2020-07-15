package com.codegym.service;


import com.codegym.dao.entity.Distributor;

public interface DistributorService {
    Distributor findById(int id);

    void save(Distributor distributor);


}
