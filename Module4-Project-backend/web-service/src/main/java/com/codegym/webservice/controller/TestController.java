package com.codegym.webservice.controller;

import com.codegym.dao.entity.info;
import com.dao.businessservice.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/info/", method = RequestMethod.GET)
    public ResponseEntity<List<info>> listAllCustomers() {
        List<info> customers = infoService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<info>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<info>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<info> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        info ifo = infoService.findById(id);
        if (ifo == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<info>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<info>(ifo, HttpStatus.OK);
    }

}
