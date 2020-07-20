package com.codegym.dao.repository;

import com.codegym.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * @return all data from Product with delete_flag is false
     */
    Page<Product> findAllByDeleteFlagFalse(Pageable pageable);
}
