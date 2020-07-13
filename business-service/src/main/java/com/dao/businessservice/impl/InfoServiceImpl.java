package com.dao.businessservice.impl;

import com.codegym.dao.entity.info;
import com.codegym.dao.repository.InfoRepository;
import com.dao.businessservice.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoRepository infoRepository;

    @Override
    public List<info> findAll() {
        return infoRepository.findAll();
    }

    @Override
    public info findById(int id) {
        return infoRepository.findById(id).orElse(null);
    }
}
