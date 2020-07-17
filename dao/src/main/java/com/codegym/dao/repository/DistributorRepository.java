package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorRepository extends JpaRepository<Distributor,Integer> {

    Page<Distributor> findAllByNameContaining(Pageable pageable,String name);
}
