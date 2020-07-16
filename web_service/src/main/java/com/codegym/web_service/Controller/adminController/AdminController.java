package com.codegym.web_service.Controller.adminController;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.Role;
import com.codegym.service.AccountService;
import com.codegym.service.EmployeeService;
import com.codegym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmployeeService employeeService;

    //------------------------------- list role -------------------------
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllRole() {
        List<Role> roles = roleService.findAllRole();
        if (roles.isEmpty()) {
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    //--------------------------------- details role ---------------------------
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") int id) {
        System.out.println("Fetching Customer with id " + id);
        Role role = roleService.findRoleById(id);
        if (role == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Role>(role, HttpStatus.OK);
    }

    //---------------------- list account ---------------------------------
    @RequestMapping(value = "/account", method = RequestMethod.GET, params = {"page", "size", "search"})
    public ResponseEntity<Page<Account>> listAllAccount(@RequestParam("page") int page,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("search") String search) throws UnknownHostException {
//        boolean check = false;
//        List<AccessTimes> accessTimesList = accessTimesService.findAll();
//        InetAddress localhost = InetAddress.getLocalHost();
//        for (int i = 0; i < accessTimesList.size(); i++) {
//            if (accessTimesList.get(i).toString().equals(localhost.getHostAddress().trim())) {
//                check = true;
//            }
//        }
//        if (check) {
//            accessTimesService.add(new AccessTimes(new Date(), localhost.getHostAddress().trim()));
//        }
        Page<Account> accountPage = accountService.pageFindALLSearchNameOfCourseOfAdmin(PageRequest.of(page, size, Sort.by("accountId").descending())
                , search);
        if (accountPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

    //--------------------- create account --------------------------------------------------
    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder uriComponentsBuilder) {
        accountService.save(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("account?page=0&size=5&search=").buildAndExpand(account.getAccountId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //-------------------------- details account --------------------------------
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable("id") int id) {
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    //--------------------- delete account --------------------------------------------------
    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") int id) {
        Account currentAccount = accountService.findAccountById(id);
        if (currentAccount == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        currentAccount.setDeleteFlag(true);
        accountService.save(currentAccount);
        return new ResponseEntity<Account>(currentAccount, HttpStatus.OK);
    }

    //--------------------- update account --------------------------------------------------
    @RequestMapping(value = "/account/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @RequestBody Account account) {
        Account currentAccount = accountService.findAccountById(id);
        if (currentAccount == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        currentAccount.setAccountId(account.getAccountId());
        currentAccount.setAccountName(account.getAccountName());
        currentAccount.setAccountPassword(account.getAccountPassword());
        currentAccount.setRole(account.getRole());
        currentAccount.setDeleteFlag(account.getDeleteFlag());
        accountService.save(currentAccount);
        return new ResponseEntity<Account>(currentAccount, HttpStatus.OK);
    }

    //--------------------------------- details Employee ---------------------------
    @RequestMapping(value = "/account/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getInfoAccount(@PathVariable("id") int id) {
        Employee employee = employeeService.findByAccountId(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


}
