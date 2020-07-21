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
<<<<<<< HEAD
   Product findByProductIdAndDeleteFlagFalse(Integer id);

=======

    List<Product> findAllByCategory_CategoryId(Integer categoryId);
>>>>>>> dbeda5d88859b2e2ae976d70a3b85f75853ae518
}
