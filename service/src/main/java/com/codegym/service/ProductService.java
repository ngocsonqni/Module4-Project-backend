package com.codegym.service;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId);
    Page<Product> findAllByDeleteFlagFalsePaging(Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId, Pageable pageable);
    Product findById(Integer id);
    void save(Product product);
    void remove(Product product);

    List<Product> findAll();

    List<Product> findAllProductByCategoryId(Integer categoryId);

    List<Product> findAllProductByBrandIdList(List<Integer> brandIdList);
}
