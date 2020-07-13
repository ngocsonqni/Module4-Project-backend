package com.codegym.service;

import com.codegym.dao.entity.info;

import java.util.List;

public interface InfoService {
    List<info> findAll();

    info findById(int id);
}
