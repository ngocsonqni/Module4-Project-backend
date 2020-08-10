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
    public void resetSession(int id) {
        String query = "CREATE EVENT abcdef ON SCHEDULE AT (CURRENT_TIMESTAMP + INTERVAL 300 SECOND ) DO UPDATE distributor SET distributor.status = 0 where" +
                " distributor.id_distributor = " + id + " and distributor.status <> 0";


        this.distributorRepository.resetStatus2(id);
    }

    @Override
    public void setStatusDistributor(int id, int status) {
        this.distributorRepository.setStatus(id, status);
    }

    @Override
    public void dropEventById(int id) {
        this.distributorRepository.dropEventById(id);
    }

    @Override
    public Distributor findByIdToDo(int id) {
        return this.distributorRepository.findByIdAndStatusIsAndDeletedIs(id, 0, false);
    }


}
