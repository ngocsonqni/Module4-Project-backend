package com.codegym.dao.repository.location;

import com.codegym.dao.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {

    public List<District> findAllByMatpContaining(String id);

    District findByName(String name);
}


