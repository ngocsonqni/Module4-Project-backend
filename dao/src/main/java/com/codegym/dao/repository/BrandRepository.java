package com.codegym.dao.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.codegym.dao.entity.Brand;
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByDeleteFlagFalse();
    Brand findBrandByIdAndDeleteFlagIsFalse(Integer id);
    Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search);
}
