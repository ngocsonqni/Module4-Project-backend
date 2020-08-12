package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.DistributorDeleteAll;
import com.codegym.dao.entity.TypeOfDistributor;
import com.codegym.service.BillService;
import com.codegym.service.DistributorService;
import com.codegym.service.TypeOfDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistributorController {
    @Autowired
    private TypeOfDistributorService typeOfDistributorService;
    @Autowired
    private DistributorService distributorService;
    @Autowired
    private BillService billService;

    @GetMapping("/distributor/{id}")
    public ResponseEntity<Distributor> findByID(@PathVariable Integer id) {
        System.out.println(id);
        Distributor distributor = this.distributorService.findById(id);
        if (distributor == null) {
            return new ResponseEntity<Distributor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Distributor>(distributor, HttpStatus.OK);
    }

    @PostMapping("/distributor")
    public void save(@RequestBody Distributor distributor) {
        this.distributorService.save(distributor);
    }

    @GetMapping("/type_distributor/{name}")
    public TypeOfDistributor findByName(@PathVariable String name) {
        return this.typeOfDistributorService.findByName(name);
    }

    @PostMapping("/distributor/create")
    public ResponseEntity<Distributor> createDistributor(@RequestBody Distributor distributor) {
        distributorService.save(distributor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Show list ,paging and sorting
    @GetMapping(value = "/distributor/list", params = {"page", "size", "search"})
    public ResponseEntity<Page<Distributor>> getAll(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("search") String search) {
        Page<Distributor> distributorPage = distributorService.pageFindAllSearchName(PageRequest.of(page, size), search);
        if (distributorPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(distributorPage, HttpStatus.OK);
    }


    @PostMapping("/distributor/deleteAll")
    public ResponseEntity<DistributorDeleteAll> deleteALl(@RequestBody int[] deleteIdList) {
        Distributor distributor;
        List<Distributor> modifyingList = new ArrayList<>();
        List<Distributor> successList = new ArrayList<>();
        List<Distributor> unsuccessList = new ArrayList<>();

        for (int item : deleteIdList) {
            distributor = this.distributorService.checkIsNotModifying(item);
            if (distributor != null) {
                List<Bill> bills = this.billService.findAllBillByDistributorId(item);
                if (bills.size() == 0) {
                    this.distributorService.deleteById(item);
                    successList.add(distributor);
                } else {
                    unsuccessList.add(distributor);
                }
            } else {
                distributor = this.distributorService.findById(item);
                modifyingList.add(distributor);
            }
        }
        DistributorDeleteAll distributorDeleteAll = new DistributorDeleteAll(successList, modifyingList,unsuccessList);
        return new ResponseEntity<>(distributorDeleteAll, HttpStatus.OK);
    }

    @GetMapping("/distributor/isNotModifying/{id}")
    public ResponseEntity<Boolean> checkIsNotModifying(@PathVariable int id) {
        Distributor distributor = this.distributorService.checkIsNotModifying(id);
        if (distributor != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

    }

    @GetMapping("/distributor/setSession/{id}/{status}")
    public void setSS(@PathVariable int id, @PathVariable int status) {
        this.distributorService.setSessionDistributorById(id);
        this.distributorService.setStatusDistributorById(id,status);
    }

    @GetMapping("/distributor/delete/{id}")
    public void deleteDistributorById(@PathVariable int id) {
        this.distributorService.deleteById(id);
        this.distributorService.removeSessionDistributorByid(id);
        this.distributorService.setStatusDistributorById(id, 0);
    }

    @GetMapping("/distributor/getListBills/{id}")
    public ResponseEntity<List<Bill>> getBillByDistributorId(@PathVariable int id) {
        List<Bill> bills = this.billService.findAllBillByDistributorId(id);
        this.distributorService.setSessionDistributorById(id);
        this.distributorService.setStatusDistributorById(id, 2);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("/distributor/removeSession/{id}")
    public void removeSession(@PathVariable int id) {
        this.distributorService.removeSessionDistributorByid(id);
        this.distributorService.setStatusDistributorById(id, 0);
    }
}
