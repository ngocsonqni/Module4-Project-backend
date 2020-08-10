package com.codegym.web_service.Controller.userController;

import com.codegym.dao.entity.Cart;
import com.codegym.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping(value = "/cart-create", method = RequestMethod.POST)
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
       this.cartService.save(cart);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
