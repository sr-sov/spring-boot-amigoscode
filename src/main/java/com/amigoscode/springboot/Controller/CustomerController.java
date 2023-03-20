package com.amigoscode.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.springboot.dao.CustomerServiceImpl;
import com.amigoscode.springboot.model.Customer;
import com.amigoscode.springboot.records.NewCustomerRequest;
import com.amigoscode.springboot.repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	private final CustomerServiceImpl customers;
	//private final CustomerRepository customers;

	
	public CustomerController(CustomerServiceImpl customerService) {
		customers = customerService;
	}
	/*
	public CustomerController(CustomerRepository customers) {
		this.customers = customers;
	}*/

	@GetMapping
	public List<Customer> getCustomers() {
		return customers.getCustomers();
	}
	
	
	
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		customers.addCustomer(request);
		//customers.save(customer);
	}
	
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		//customers.deleteById(id);
	}
	
	@PutMapping("{customerId}")
	public void updateCustomer(
			@PathVariable("customerId") Integer id,
			@RequestBody NewCustomerRequest request
			){
		//Customer newCustomer = customers.findById(id);
		//customers.save(newCustomer);
	}
	
	//Service and Components to edit objects
}
