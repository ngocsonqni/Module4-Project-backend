package com.codegym.web_service.Controller.employeeController;

import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.EmployeeDTO;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8080")
@RestController
public class employeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployeeAvailable() {
        List<Employee> employeeList= employeeService.findAll();
        if(employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    @GetMapping("employee/list/{id}")
    public ResponseEntity<?> findAvailableEmployee(@PathVariable int id) {
        Employee employee=employeeService.findById(id);
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
        if(employee!=null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "employee/list/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Employee> editEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        Employee employee1 = employeeService.findById(id);
        if(employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employee1.setImage(employee.getImage());
        employee1.setName(employee.getName());
        employee1.setGender(employee.getGender());
        employee1.setBirthday(employee.getBirthday());
        employee1.setAddress(employee.getAddress());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setPosition(employee.getPosition());
        employee1.setDepartment(employee.getDepartment());
        employee1.setIdAccount(employee.getIdAccount());
        employeeService.save(employee1);
        return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
    }
}
