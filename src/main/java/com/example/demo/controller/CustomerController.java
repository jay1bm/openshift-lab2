
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    // private List<Customer> customers = new ArrayList<Customer>();
	@Autowired
	private CustomerService customerService;
	
    @GetMapping
    public List<Customer> getCustomers() {
        // return customers;
        return customerService.getCustomers();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    // public Customer createCustomer(@RequestBody Customer customer) {
    public Customer createCustomer(@RequestBody Customer customer) {
        List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
        return customer;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {

    	// Collection<Customer> customers = null;
		// Optional<Customer> customer = customers.stream().filter(p -> p.getId().equals(id)).findFirst();
		Optional<Customer> customer = customerService.getCustomer(id);

		if(customer.isPresent()) {
            return customer.get();
        }
        throw new ResourceNotFoundException();
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        // Collection<Customer> customers = null;
    	Optional<Customer> result = customerService.updateCustomer(id, customer);
    	
    	// if(customers.removeIf(p -> p.getId().equals(id))) {
    	if(result.isPresent()) {
    	// customers.add(customer);
            return customer;
        }
        throw new ResourceNotFoundException();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Long id) {

        // Collection<Customer> customers = null;
		// if(!customers.removeIf(p -> p.getId().equals(id))) {
    	
    	Optional<Customer> result = customerService.deleteCustomer(id);
    	
        throw new ResourceNotFoundException();
        }
    }
