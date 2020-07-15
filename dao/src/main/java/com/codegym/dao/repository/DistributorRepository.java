package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface DistributorRepository extends JpaRepository<Distributor,Integer> {

    @Modifying
    @Query("update Distributor u set u.deleted = ?1 where u.id = ?2")
    void delete(boolean deleted, Integer id);
}
