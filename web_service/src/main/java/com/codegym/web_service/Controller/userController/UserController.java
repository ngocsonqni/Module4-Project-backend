package com.codegym.web_service.Controller.userController;


import com.codegym.dao.DTO.UserDTO;
import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.User;
import com.codegym.service.UserService;
import com.codegym.web_service.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
//@CrossOrigin(value = "*")
@Controller
class UserController {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    //-------------------Retrieve All Customers--------------------------------------------------------
    @GetMapping(value = "/customers", params = {"page",
            "size",
            "search",
            "value1",
            "value2"
    })
    public ResponseEntity<Page<UserDTO>> listAllUserByDeleteFlagIsFalse(@RequestParam("page") int page,
                                                                        @RequestParam("size") int size,
                                                                        @RequestParam("search") String search,
                                                                        @RequestParam(value = "value1",defaultValue = "1900-01-01") String value1,
                                                                        @RequestParam(value = "value2",defaultValue = "3000-01-01") String value2
    ) {
        Page<UserDTO> userDTOPage = userService.getAllUserDto("%" + search + "%", "%" + search + "%", "%" + search + "%", "%" + search + "%", value1, value2, PageRequest.of(page, size));
//        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
//        double totalFull = 0;
//        for (User user : users) {
//            UserDTO userDTO = new UserDTO();
//            userDTO.setId(user.getId());
//            userDTO.setUserName(user.getUserName());
//            userDTO.setBirthday(user.getBirthday());
//            userDTO.setAddress(user.getAddress());
//            userDTO.setEmail(user.getEmail());
//            userDTO.setPhone(user.getPhone());
//            userDTO.setGender(user.getGender());
//            userDTO.setImageUrl(user.getImageUrl());
//            userDTO.setDeleteFlag(user.getDeleteFlag());
//            userDTO.setAccount(user.getAccount());
//            userDTO.setListOrder(user.getListOrder());
//            for (Order total : user.getListOrder()) {
//                totalFull += total.getTotalMoney();
//            }
//            userDTO.setTotal(totalFull);
//            totalFull = 0;
//            usersDTO.add(userDTO);
//        }
        //Page<UserDTO> userDTOPage = new PageImpl<>(usersDTO,PageRequest.of(page, size),users.getTotalElements());
        System.out.println(page);
        if (userDTOPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOPage , HttpStatus.OK);
    }

    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCustomer(@PathVariable("id") int id) {
        User user = userService.findGetId(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        userService.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //-------------------Edit a Customer--------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<User> updateCustomer(@Valid @PathVariable("id") int id, @RequestBody User user) {
        User currentUser = userService.findGetId(id);

        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setId(user.getId());
        currentUser.setUserName(user.getUserName());
        currentUser.setBirthday(user.getBirthday());
        currentUser.setGender(user.getGender());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhone(user.getPhone());
        currentUser.setImageUrl(user.getImageUrl());
        userService.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User user = userService.findGetId(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customer-account/{accountName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCustomerByAccount(@PathVariable("accountName") String accountName) {
        User user = userService.findUserByAccountName(accountName);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
