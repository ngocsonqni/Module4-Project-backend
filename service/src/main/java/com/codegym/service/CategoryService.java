package com.codegym.service;

import com.codegym.dao.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer category_id);
}
