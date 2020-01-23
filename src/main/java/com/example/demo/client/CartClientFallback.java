package com.example.demo.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Item;

@Component
public class CartClientFallback implements CartClient {

    @Override
    public List<Item> getCartByCustomerId(Long customerId) {

        return Collections.emptyList();
    }

    @Override
    public Item addCartItem(Item item) {
        return null;
    }

    @Override
    public Item removeCartItem(Long id) {
        return null;
    }

}