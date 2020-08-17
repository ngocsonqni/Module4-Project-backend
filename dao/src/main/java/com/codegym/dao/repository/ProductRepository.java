package com.codegym.dao.repository;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findAllByDeleteFlagFalse(Pageable pageable);

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

    @Query(value = "SELECT*\n" +
            "FROM code_bakery.product\n" +
            "where ((SELECT year(code_bakery.product.create_at))= :y and (SELECT month(code_bakery.product.create_at))= :m)\n" +
            "GROUP BY code_bakery.product.product_name\n" +
            "having MAX(code_bakery.product.amount_sold)\n" +
            "order by code_bakery.product.amount_sold desc\n" +
            "limit 5",
            nativeQuery = true)
    List<Product> findAllByTop(@Param("y") String y, @Param("m") String m);


    List<Product> findAllByCategory_CategoryIdAndDeleteFlagFalse(Integer categoryId);
}
