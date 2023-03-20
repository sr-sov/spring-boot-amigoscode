package com.amigoscode.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoscode.springboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
