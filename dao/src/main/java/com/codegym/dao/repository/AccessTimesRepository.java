package com.codegym.dao.repository;

import com.codegym.dao.entity.AccessTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTimesRepository extends JpaRepository<AccessTimes, Integer> {

}
