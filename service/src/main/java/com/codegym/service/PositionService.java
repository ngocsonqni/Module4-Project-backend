package com.codegym.service;

import com.codegym.dao.entity.Position;

public interface PositionService {
    Iterable<Position> findAll();
}
