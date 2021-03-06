package com.codegym.service.Impl;

import com.codegym.dao.entity.Product;
import com.codegym.dao.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId) {
        return productRepository.findDistinctByCategory_CategoryIdAndDeleteFlagIsFalseOrderByBrand(categoryId);
    }

    @Override
    public Page<Product> findAllByDeleteFlagFalsePaging(Pageable pageable) {
        return productRepository.findAllByDeleteFlagFalse(pageable);
    }

    @Override
    public List<Product> findAllByDeleteFlagFalse() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(categoryId, brandId, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndDeleteFlagIsFalse(categoryId, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, String price, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(categoryId, brandId, productName, price, pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(String productName, String price, Pageable pageable) {
        return productRepository.findAllByProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(productName, price, pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContainingAndDeleteFlagIsFalse(String productName, Pageable pageable) {
        return productRepository.findAllByProductNameContainingAndDeleteFlagIsFalse(productName, pageable);
    }

    @Override
    public Page<Product> findAllByPriceContainingAndDeleteFlagIsFalse(String price, Pageable pageable) {
        return productRepository.findAllByPriceContainingAndDeleteFlagIsFalse(price, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(categoryId, brandId, productName, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndPriceContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String price, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndBrand_IdAndPriceContainingAndDeleteFlagIsFalse(categoryId, brandId, price, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, String price, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(categoryId, productName, price, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndProductNameContainingAndDeleteFlagIsFalse(categoryId, productName, pageable);
    }

    @Override
    public Page<Product> findAllByCategory_CategoryIdAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String price, Pageable pageable) {
        return productRepository.findAllByCategory_CategoryIdAndPriceContainingAndDeleteFlagIsFalse(categoryId, price, pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findByProductIdAndDeleteFlagFalse(id);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        product.setDeleteFlag(true);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> findAllProductByBrandIdList(List<Integer> brandIdList) {
        return productRepository.productFindByListBrand(brandIdList);
    }

    @Override
    public List<Product> findAllByTop(String y, String m) {
        return productRepository.findAllByTop(y,m);
    }
    @Override
    public List<Product> findAllProductByCategoryAndDeleteFlagIsFalse(int categoryId) {
        return productRepository.findAllByCategory_CategoryIdAndDeleteFlagFalse(categoryId);
    }
}
