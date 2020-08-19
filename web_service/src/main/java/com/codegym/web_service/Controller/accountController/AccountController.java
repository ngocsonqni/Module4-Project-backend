package com.codegym.web_service.Controller.accountController;

import com.codegym.dao.DTO.AccountDTO;
import com.codegym.dao.DTO.JwtResponse;
import com.codegym.service.Impl.AccountServiceImpl;
import com.codegym.web_service.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.codegym.dao.DTO.MemberDTO;
import com.codegym.dao.entity.Account;
import com.codegym.dao.entity.Role;
import com.codegym.service.AccountService;
import com.codegym.service.RoleService;
import com.codegym.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
class AccountController {
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired(required = false)
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
//    @GetMapping("/admin")
//    public ResponseEntity<?> helloAdmin() {
//        accountDTO = new AccountDTO("admin", "Hello");
//        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
//    }
//
//    @GetMapping("/member")
//    public ResponseEntity<?> helloMember() {
//        accountDTO = new AccountDTO("member", "Hello");
//        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
//    }

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO.getAccountPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDTO.getAccountName(), accountDTO.getAccountPassword())
        );
        UserDetails userDetails = accountServiceImpl.loadUserByUsername(authentication.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    //--------------------- create MEMBER account --------------------------------------------------
    @RequestMapping(value = "/createMemberAccount", method = RequestMethod.POST)
    public ResponseEntity<Void> createMemberAccount(@RequestBody MemberDTO memberDTO, UriComponentsBuilder uriComponentsBuilder) {
        Account account1 = accountService.findAccountByName(memberDTO.getAccountName());
        Role userRole = roleService.findRoleById(4);
        if (account1 != null) {
            throw new UsernameNotFoundException("Tên đăng nhập đã tồn tại");
        } else {
            memberDTO.setAccountPassword((passwordEncoder.encode(memberDTO.getAccountPassword())));
            memberDTO.setRole(userRole);
            accountService.save(memberDTO);
            Account account = accountService.findAccountByName(memberDTO.getAccountName());
            memberDTO.setAccount(account);
            userService.save(memberDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponentsBuilder.path("/customers/{id}").buildAndExpand(memberDTO.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
    }

}