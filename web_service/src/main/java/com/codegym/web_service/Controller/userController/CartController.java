package com.codegym.web_service.Controller.userController;

import com.codegym.dao.entity.Cart;
import com.codegym.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "/cart-delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteCart(@RequestBody Cart cart) {
        Optional<Cart> currentCart = this.cartService.findById(cart.getId());
        if (currentCart.isPresent()) {
            this.cartService.delete(currentCart.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/cart-quantity", method = RequestMethod.POST)
    public ResponseEntity<Void> changeCartQuantity(@RequestBody Cart cart) {
        Optional<Cart> currentCart = this.cartService.findById(cart.getId());
        if (currentCart.isPresent()) {
            currentCart.get().setQuantity(cart.getQuantity());
            this.cartService.save(currentCart.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
