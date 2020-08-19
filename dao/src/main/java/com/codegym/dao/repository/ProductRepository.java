package com.codegym.dao.repository;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByDeleteFlagFalse(Pageable pageable);

    List<Product> findAllByDeleteFlagFalse();

    /**
     * @return all data from Product with categoryId is false
     */
    List<Product> findDistinctByCategory_CategoryIdAndDeleteFlagIsFalseOrderByBrand(Integer categoryId);

    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndDeleteFlagIsFalse(Integer categoryId, Integer BrandId, Pageable pageable);

    /**
     * search with categoryId, brandID, productName, price
     */
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, String price, Pageable pageable);

    /**
     * search with categoryId, brandID, productName
     */
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndProductNameContainingAndDeleteFlagIsFalseAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String productName, Pageable pageable);

    /**
     * search with categoryId, brandID, price
     */
    Page<Product> findAllByCategory_CategoryIdAndBrand_IdAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, Integer brandId, String price, Pageable pageable);

    /**
     * search with categoryId, productName, price
     */
    Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, String price, Pageable pageable);

    /**
     * search with categoryId, productName
     */
    Page<Product> findAllByCategory_CategoryIdAndProductNameContainingAndDeleteFlagIsFalse(Integer categoryId, String productName, Pageable pageable);

    /**
     * search with categoryId, price
     */
    Page<Product> findAllByCategory_CategoryIdAndPriceContainingAndDeleteFlagIsFalse(Integer categoryId, String price, Pageable pageable);

    /**
     * search with productName, price
     */
    Page<Product> findAllByProductNameContainingAndPriceContainingAndDeleteFlagIsFalse(String productName, String price, Pageable pageable);

    /**
     * search with productName
     */
    Page<Product> findAllByProductNameContainingAndDeleteFlagIsFalse(String productName, Pageable pageable);

    /**
     * search with price
     */
    Page<Product> findAllByPriceContainingAndDeleteFlagIsFalse(String price, Pageable pageable);

    Page<Product> findAllByCategory_CategoryIdAndDeleteFlagIsFalse(Integer categoryId, Pageable pageable);

    Product findByProductIdAndDeleteFlagFalse(Integer id);

    List<Product> findAllByCategory_CategoryId(Integer categoryId);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM product inner join brand " +
            "on product.brand_id = brand.brand_id " +
            "where product.brand_id in ?1 " +
            "order by product_id")
    List<Product> productFindByListBrand(List<Integer> brandIds);
}
