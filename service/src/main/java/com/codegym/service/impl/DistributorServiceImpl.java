package com.codegym.service.impl;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.repository.DistributorRepository;
import com.codegym.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    @Override
    public Distributor findById(int id) {
        return distributorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Distributor distributor) {
        distributorRepository.save(distributor);
    }

    @Override
    public List<Distributor> findAll() {
        return distributorRepository.findAll();
    }

    @Override
    public Page<Distributor> pageFindAllSearchName(Pageable pageable, String search) {
        Page<Distributor> distributorPage = distributorRepository.findAllByNameContainingAndDeleted(pageable, search, false);
        return distributorPage;
    }


//Add-----------------------------------------------------------------------------------

    @Override
    public List<Distributor> findAllByDeleted(boolean isNotDeleted) {
        return this.distributorRepository.findAllByDeleted(isNotDeleted);
    }

    @Override
    public void deleteById(int id) {
        this.distributorRepository.delete(true, id);
    }

    @Override
    public Distributor isExistDistributor(String name, int id) {
        return this.distributorRepository.findAllByNameAndIdIsNot(name, id);
    }

    @Override
    public Distributor checkIsNotModifying(int id) {
        return this.distributorRepository.findAllByIdAndStatusIs(id);
    }

    @Override
    public void setStatusDistributorById(int id, int status) {
        this.distributorRepository.setStatusDistributorById(id, status);
    }

    @Override
    public void setSessionDistributorById(int id) {
        this.distributorRepository.setSessionDistributorById(id);
    }

    @Override
    public void removeSessionDistributorByid(int id) {
        this.distributorRepository.removeSessionDistributorById(id);
    }

    @Override
    public Distributor inSession(int id) {
        return this.distributorRepository.findAllByIdAndStatusIsNot(id, 0);
    }

    @Override
    public void increaseSessionById(int id) {
        this.distributorRepository.increaseNumSessionById(id);
    }

    @Override
    public int getNumOfSessionById(int id) {
        return this.distributorRepository.getNumOfSessionById(id);
    }

    @Override
    public Distributor isNotDeletedById(int id) {
        return distributorRepository.isNotDeletedById(id);
    }


}
