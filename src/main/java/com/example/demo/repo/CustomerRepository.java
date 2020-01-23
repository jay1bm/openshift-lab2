package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;

import antlr.collections.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	java.util.List<Customer> findAll();

	
}
