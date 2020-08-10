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
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, String price, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(String productName, String price, Pageable pageable);
    Page<Product> findAllByProductNameContainingAndDeleteFlagIsFalse(String productName, Pageable pageable);
    Page<Product> findAllByPriceContainingAndDeleteFlagIsFalse(String price, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndPriceContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String price, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, String price, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String price, Pageable pageable);

    Product findById(Integer id);
    void save(Product product);
    void remove(Product product);

    List<Product> findAll();

    List<Product> findAllProductByCategoryId(Integer categoryId);

    List<Product> findAllProductByBrandIdList(List<Integer> brandIdList);
}
