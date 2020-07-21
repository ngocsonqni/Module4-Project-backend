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
    /**
     * @return all data from Product with delete_flag is false
     */
    Page<Product> findAllByDeleteFlagFalse(Pageable pageable);

    List<Product> findAllByCategory_CategoryId(Integer categoryId);
    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM product inner join brand " +
            "on product.brand_id = brand.brand_id " +
            "where product.brand_id in ?1 " +
            "order by product_id")
    List<Product> productFindByListBrand(List<Integer> brandIds);
}
