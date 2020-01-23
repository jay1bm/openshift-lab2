package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CartClient;
import com.example.demo.model.Item;

@RestController
@RequestMapping("/v1/customers/{customerId}/carts")
public class CustomerCartsController {

    private CartClient cartClient;

    @Autowired
    public CustomerCartsController(CartClient cartClient) {
        super();
        this.cartClient = cartClient;
    }

    @PostMapping
    public Item addItem( @PathVariable("customerId") Long customerId, @RequestBody Item item) {
        return cartClient.addCartItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("customerId") Long customerId, @PathVariable("id") Long id) {
        cartClient.removeCartItem(id);
    }

    @GetMapping
    public List<Item> getCart(@PathVariable("customerId") Long customerId){
        return cartClient.getCartByCustomerId(customerId);
    }

}
