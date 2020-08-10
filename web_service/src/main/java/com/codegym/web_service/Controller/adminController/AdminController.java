package com.codegym.web_service.Controller.adminController;

import com.codegym.service.*;
import com.codegym.web_service.AsyncService.AsyncService;
import com.codegym.web_service.security.JwtTokenUtil;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;

import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.Role;
import com.codegym.dao.entity.User;
import com.codegym.service.AccountService;
import com.codegym.service.EmployeeService;
import com.codegym.service.RoleService;
import com.codegym.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
public class AdminController {
    @Autowired(required = false)
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccessTimesService accessTimesService;
    @Autowired
    private AsyncService asyncDeleteAccount;

    //------------------------------- list role -------------------------
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllRole() {
        List<Role> roles = roleService.findAllRole();
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    //--------------------------------- details role ---------------------------
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") int id) {
        Role role = roleService.findRoleById(id);
        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    //------------------------------- list account -------------------------
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listAllAccountList() {
        List<Account> accounts = accountService.findAllAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }

    //---------------------- list account ---------------------------------
    @RequestMapping(value = "/account", method = RequestMethod.GET, params = {"page", "size", "search", "role"})
    public ResponseEntity<Page<Account>> listAllAccount(@RequestParam("page") int page,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("search") String search,
                                                        @RequestParam("role") String nameRole) {
        Page<Account> accountPage = accountService.pageFindALLSearchNameOfCourseOfAdmin(PageRequest.of(page, size, Sort.by("accountId").ascending())
                , nameRole, search);

        if (accountPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountPage, HttpStatus.OK);
    }

    //--------------------- create account --------------------------------------------------
    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder uriComponentsBuilder) {
        Account account1 = accountService.findAccountByName(account.getAccountName());
        List<Role> roles = roleService.findAllRole();
        if (account1 != null) {
            throw new UsernameNotFoundException("Tên đăng nhập đã tồn tại");
        } else {
            account.setAccountPassword((passwordEncoder.encode(account.getAccountPassword())));
            accountService.save(account);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponentsBuilder.path("account?page=0&size=5&search=").buildAndExpand(account.getAccountId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
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
    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") int id, @RequestBody Account account) throws MessagingException {
        Account currentAccount = accountService.findAccountById(id);
        if (currentAccount == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        currentAccount.setDeleteFlag(true);
        currentAccount.setReason(account.getReason());
        accountService.save(currentAccount);
        if (account.getRole().getRoleName().equals("ROLE_ADMIN") || account.getRole().getRoleName().equals("ROLE_PARTNER") || account.getRole().getRoleName().equals("ROLE_WAREHOUSE")) {
            asyncDeleteAccount.sendDeleteEmailWithEmployee(employeeService.findByAccountId(account.getAccountId()));
        } else {
            asyncDeleteAccount.sendDeleteEmailWithUser(userService.findUserByAccountId(account.getAccountId()));
        }
        asyncDeleteAccount.deleteAccount(currentAccount);
        return new ResponseEntity<Account>(currentAccount, HttpStatus.OK);
    }

    //--------------------- update account --------------------------------------------------
    @RequestMapping(value = "/account/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @RequestBody Account account) throws MessagingException {
        Account currentAccount = accountService.findAccountById(id);
        if (currentAccount == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        try {
            String patternAccountName = "^[a-zA-Z0-9\\,\\.\\-\\_\\@]{1,}$";
            String patternAccountPassword = "^[a-zA-Z0-9\\$\\.\\/]{1,}$";
            currentAccount.setAccountId(account.getAccountId());
            if (account.getAccountName().matches(patternAccountName)) {
                currentAccount.setAccountName(account.getAccountName());
            } else {
                return new ResponseEntity<Account>(HttpStatus.NOT_ACCEPTABLE);
            }
            if (account.getAccountPassword().matches(patternAccountPassword)) {
                currentAccount.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
            } else {
                return new ResponseEntity<Account>(HttpStatus.NOT_ACCEPTABLE);
            }
            currentAccount.setRole(account.getRole());
            currentAccount.setDeleteFlag(account.getDeleteFlag());
            accountService.save(currentAccount);
        } catch (Exception e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_ACCEPTABLE);
        }
        if (account.getRole().getRoleName().equals("ROLE_ADMIN") || account.getRole().getRoleName().equals("ROLE_PARTNER") || account.getRole().getRoleName().equals("ROLE_WAREHOUSE")) {
            asyncDeleteAccount.sendEmailWithEmployee(employeeService.findByAccountId(account.getAccountId()));
        } else {
            asyncDeleteAccount.sendEmailWithUser(userService.findUserByAccountId(account.getAccountId()));
        }
        return new ResponseEntity<Account>(currentAccount, HttpStatus.OK);
    }

    //--------------------------------- details Employee ---------------------------
    @RequestMapping(value = "/account/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getInfoAccount(@PathVariable("id") int id) {
        Employee employee = employeeService.findByAccountId(id);
        if (employee == null) {
            employee = new Employee();
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    //--------------------------------- details User ---------------------------
    @RequestMapping(value = "/account/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getInfoAccountUser(@PathVariable("id") int id) {
        User user = userService.findUserByAccountId(id);
        if (user == null) {
            user = new User();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //---------------------- list employee ---------------------------------
    @RequestMapping(value = "/employee/page-list", method = RequestMethod.GET, params = {"page", "size", "search"})
    public ResponseEntity<Page<Employee>> listAllEmployee(@RequestParam("page") int page,
                                                          @RequestParam("size") int size,
                                                          @RequestParam("search") String search) {
        Page<Employee> employeePage = employeeService.findAllEmployeeWithPage(search, PageRequest.of(page, size, Sort.by("id").ascending()));

        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
}
