package com.codegym.dao.repository;
import com.codegym.dao.DTO.BrandStatistical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.codegym.dao.entity.Brand;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByDeleteFlagFalse();
    Brand findBrandByIdAndDeleteFlagIsFalse(Integer id);
    Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search);

    @Query(value = "select product.product_name as \"productName\", (product.price * product.quantity) as \"total\"\n" +
            "from product\n" +
            "group by product_name\n" +
            "order by total desc limit 10;", nativeQuery = true)
    List<BrandStatistical> totalRevenue();
}