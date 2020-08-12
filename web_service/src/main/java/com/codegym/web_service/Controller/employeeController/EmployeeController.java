package com.codegym.web_service.Controller.employeeController;
import com.codegym.dao.DTO.AccountDTOEmployee;
import com.codegym.web_service.AsyncService.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.codegym.dao.entity.*;
import com.codegym.service.AccountService;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
//@SessionAttributes("sendOTP")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AsyncService asyncService;
    private AtomicInteger count=new AtomicInteger();

    @Autowired
    @ModelAttribute("sendOTP")
    public Map<String, String> sendOTP() {
        return new HashMap<>();
    }
    private static String temp;
//    @ModelAttribute("sendOTP")Map<String,String> sendOTP ,
    @RequestMapping(value = "/employee/account/name/{accountName}/otp", method = RequestMethod.GET)
    protected void doGet( @PathVariable String accountName) throws MessagingException {
        Employee employee = employeeService.findByAccountName(accountName);
        int randomPin   =(int) (Math.random()*9000)+1000;
        String otp  = String.valueOf(randomPin);
//        sendOTP.put(accountName,otp);
        asyncService.sendChangePasswordCode(employee,otp);

        temp=otp;

//        new java.util.Timer().schedule(
//                new java.util.TimerTask() {
//                    @Override
//                    public void run() {
//                        // your code here
//                    }
//                },
//                5000
//        );


//        HttpSession session = request.getSession();
//        session.setAttribute(accountName,otp);
//        session.setMaxInactiveInterval(300);

    }



    //return list of employee
    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployeeAvailable() {
        List<Employee> employeeList = employeeService.findAll();
//        if(employeeList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
//        }
        return (employeeList.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    //return an employee using id
    @GetMapping("employee/list/{id}")
    public ResponseEntity<?> findAvailableEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(employee.getId());
//        employeeDTO.setImage(employee.getImage());
//        employeeDTO.setName(employee.getName());
//        employeeDTO.setGender(employee.getGender());
//        employeeDTO.setBirthday(employee.getBirthday());
//        employeeDTO.setAddress(employee.getAddress());
//        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
//        employeeDTO.setEmail(employee.getEmail());
//        employeeDTO.setPosition(employee.getPosition().getName());
//        employeeDTO.setDepartment(employee.getDepartment().getName());
//        employeeDTO.setIdAccount(employee.getIdAccount());
        return employee != null ? new ResponseEntity<Employee>(employee, HttpStatus.OK) : new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

    }

    // find an employee by their account name
    @GetMapping("employee/list/name/{acountName}")
    public ResponseEntity<?> findEmployeeByAccount(@PathVariable String acountName) {
        Employee employee = employeeService.findByAccountName(acountName);
        if (employee != null) return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    //edit an employee using id
    @RequestMapping(value = "employee/list/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> editEmployee(@Valid @PathVariable("id") int id, @RequestBody Employee employeeDTO) {
        Employee employee1 = employeeService.findById(id);
        if (employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employee1.setImage(employeeDTO.getImage());
        employee1.setName(employeeDTO.getName());
        employee1.setGender(employeeDTO.getGender());
        employee1.setBirthday(employeeDTO.getBirthday());
        employee1.setAddress(employeeDTO.getAddress());
        employee1.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee1.setEmail(employeeDTO.getEmail());
        employee1.setPosition(employeeDTO.getPosition());
        employee1.setDepartment(employeeDTO.getDepartment());
//        employee1.setPosition(positionService.findByPositionName(employeeDTO.getPosition()));
//        employee1.setDepartment(departmentService.findByNameDepartment(employeeDTO.getDepartment()));
        employeeService.save(employee1);
        return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
    }

    //edit account of employee using their account name
    @RequestMapping(value = "employee/account/name/{accountName}", method = RequestMethod.PATCH)
//    @ModelAttribute("sentOTP")Map<String, String> sendOTP,
    public ResponseEntity<Account> editPassWordAccount( @Valid @PathVariable("accountName") String accountName, @RequestBody AccountDTOEmployee account
                                                       ) throws MessagingException, ServletException, IOException {

        Account account1 = accountService.findAccountByName(accountName);
        Employee employee = employeeService.findByAccountName(accountName);
        if (account1 == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        if(!passwordEncoder.matches(account.getOldPassword(), account1.getAccountPassword())) {
            return new ResponseEntity<Account>(account1, HttpStatus.NOT_FOUND);
        } else {
//            if(count.incrementAndGet()==1) {
//                int randomPin   =(int) (Math.random()*9000)+1000;
//                String otp  = String.valueOf(randomPin);
//                asyncService.sendChangePasswordCode(employee,otp);
//
//            }
        }
//        if(!Objects.equals(sendOTP.get(accountName),account.getOtp())) {
            if(!Objects.equals(temp,account.getOtp())) {
            return new ResponseEntity<Account>(account1, HttpStatus.NOT_FOUND);
        } else {
            account1.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
            accountService.save(account1);
            temp="";
//            sendOTP.remove(accountName);
            return new ResponseEntity<Account>(account1, HttpStatus.OK);
        }

//        account1.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
//        accountService.save(account1);
//        return new ResponseEntity<Account>(account1, HttpStatus.OK);
    }

    //find account of employee by their account name
    @GetMapping("employee/account/name/{accountName}")
    public ResponseEntity<Account> findAccountByName(@PathVariable String accountName) {
        Account account = accountService.findAccountByName(accountName);
        return account != null ? new ResponseEntity<>(account, HttpStatus.OK) : new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }

    //return the list of position
    @GetMapping("employee/position")
    public ResponseEntity<List<Position>> findAllPosition() {
        List<Position> positionList = positionService.findAll();
        return positionList.isEmpty() ? new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
    }

    //return the list of department
    @GetMapping("employee/department")
    public ResponseEntity<List<Department>> findAllDepartment() {
        List<Department> departmentList = departmentService.findAll();
        return departmentList.isEmpty() ? new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);
    }
    //handle error
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
