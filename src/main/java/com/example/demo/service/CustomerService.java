package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        super();
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> getCustomer(Long id) {
        return customerRepo.findById(id);
    }

    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        if(customerRepo.findById(id).isPresent()) {
            customerRepo.deleteById(id);
            return Optional.of(customerRepo.save(customer));
        }
        return Optional.empty();
    }

    public Optional<Customer> deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()) {
            customerRepo.delete(customer.get());
        }
        return customer;
    }
}