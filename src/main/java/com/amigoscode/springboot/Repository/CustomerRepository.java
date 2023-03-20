package com.amigoscode.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigoscode.springboot.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
