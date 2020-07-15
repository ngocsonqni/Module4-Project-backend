package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.TypeOfDistributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeOfDistributorRepository extends JpaRepository<TypeOfDistributor, Integer> {
//    @Query("SELECT u FROM TypeOfDistributor u WHERE u.name = ?1")
//    TypeOfDistributor findByName(String name);

    TypeOfDistributor findByName(String name);
}
