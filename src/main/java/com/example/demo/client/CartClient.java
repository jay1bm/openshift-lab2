package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Item;

@FeignClient(name = "cart-service", url = "localhost:8081", fallback = CartClientFallback.class)
public interface CartClient {

    @RequestMapping(method = RequestMethod.GET, path = "/v1/carts/customer/{customerId}")
    public List<Item> getCartByCustomerId(@PathVariable("customerId") Long customerId);

    @RequestMapping(method = RequestMethod.POST, path = "/v1/carts")
    public Item addCartItem(@RequestBody Item item);

    @RequestMapping(method = RequestMethod.DELETE, path = "/v1/carts/{id}")
    public Item removeCartItem(@PathVariable Long id);

}