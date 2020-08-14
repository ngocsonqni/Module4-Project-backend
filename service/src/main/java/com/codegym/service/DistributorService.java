package com.codegym.service;


import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DistributorService {
    Distributor findById(int id);

    void save(Distributor distributor);

    List<Distributor> findAll();

    Page<Distributor> pageFindAllSearchName (Pageable pageable, String search);




//Add-----------------------------------------------------------------------
List<Distributor> findAllByDeleted(boolean isNotDeleted);
    void deleteById(int id);
    Distributor isExistDistributor(String name, int id);

    Distributor checkIsNotModifying(int id);
    void setStatusDistributorById(int id, int status);

    void setSessionDistributorById(int id);
    void removeSessionDistributorByid(int id);

    Distributor inSession(int id);

    void increaseSessionById(int id);
    int getNumOfSessionById(int id);
}
