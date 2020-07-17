package com.codegym.web_service.Controller.adminController;

import com.codegym.dao.entity.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private com.codegym.service.RuleService ruleService;

    @RequestMapping(value = "/rule/", method = RequestMethod.GET)
    public ResponseEntity<List<Rule>> listAllCustomers() {
        List<Rule> rules = ruleService.findAllRule();
        if (rules.isEmpty()) {
            return new ResponseEntity<List<Rule>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Rule>>(rules, HttpStatus.OK);
    }

    @RequestMapping(value = "/rule/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rule> getCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Rule rule1 = ruleService.findRuleById(id);
        if (rule1 == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Rule>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Rule>(rule1, HttpStatus.OK);
    }
}
