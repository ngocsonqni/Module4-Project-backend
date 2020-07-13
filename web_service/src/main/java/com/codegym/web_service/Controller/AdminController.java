package com.codegym.web_service.Controller;

import com.codegym.dao.entity.role;
import com.codegym.service.roleService;
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
public class AdminController {
    @Autowired
    private com.codegym.service.roleService roleService;

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<role>> listAllCustomers() {
        List<role> roles = roleService.findAllRole();
        if (roles.isEmpty()) {
            return new ResponseEntity<List<role>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<role>>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<role> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        role role1 = roleService.findRoleById(id);
        if (role1 == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<role>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<role>(role1, HttpStatus.OK);
    }
}
