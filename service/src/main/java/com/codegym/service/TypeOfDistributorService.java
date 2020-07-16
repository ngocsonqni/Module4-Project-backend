package com.codegym.service;

import com.codegym.dao.entity.TypeOfDistributor;

public interface TypeOfDistributorService {
    TypeOfDistributor findByName(String name);
}
