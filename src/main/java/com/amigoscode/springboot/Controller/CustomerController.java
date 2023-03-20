package com.amigoscode.springboot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.springboot.Model.Customer;
import com.amigoscode.springboot.Repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	private final CustomerRepository customers;

	public CustomerController(CustomerRepository customers) {
		this.customers = customers;
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customers.findAll();
	}
}
