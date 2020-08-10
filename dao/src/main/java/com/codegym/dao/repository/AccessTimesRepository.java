package com.codegym.dao.repository;

import com.codegym.dao.entity.AccessTimes;
import com.codegym.dao.DTO.AccessTimesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessTimesRepository extends JpaRepository<AccessTimes, Integer> {
    @Query(value = "SELECT date_format(v.date,'%d/%m/%Y') as dates ,count(v.date) as counts FROM AccessTimes as v GROUP BY v.date")
    List<AccessTimesDTO> countAccessTimes();

    @Query(value = "SELECT date_format(v.date,'%m/%Y') as dates,count(v.date) as counts FROM AccessTimes as v GROUP BY month(v.date), year(v.date)")
    List<AccessTimesDTO> countAccessTimesMonth();

    @Query(value = "SELECT date_format(v.date,'%Y') as dates,count(v.date) as counts FROM AccessTimes as v GROUP BY year(v.date)")
    List<AccessTimesDTO> countAccessTimesYear();
}
