package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Distributor;
import com.codegym.dao.entity.TypeOfDistributor;
import com.codegym.service.DistributorService;
import com.codegym.service.TypeOfDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class DistributorController {

    @Autowired
    private TypeOfDistributorService typeOfDistributorService;
    @Autowired
    private DistributorService distributorService;


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

}
