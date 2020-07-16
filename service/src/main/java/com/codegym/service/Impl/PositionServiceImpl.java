package com.codegym.service.Impl;

import com.codegym.dao.entity.Position;
import com.codegym.dao.repository.PositionRepository;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
