package com.codegym.dao.repository;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * @return all data from Product with delete_flag is false
     */
    Page<Product> findAllByDeleteFlagFalse(Pageable pageable);
    /**
     * @return all data from Product with categoryId is false
     */
    List<Product> findDistinctByCategory_CategoryIdAndDeleteFlagIsFalseOrderByBrand(Integer categoryId);

    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(Integer categoryId, Integer BrandId, Pageable pageable);
    Page<Product> findAllByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId, Pageable pageable);
}
