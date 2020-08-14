package com.codegym.dao.repository.location;
import com.codegym.dao.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProvinceRepository extends JpaRepository<Province, String> {
    Province findByName(String name);
}
