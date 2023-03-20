package com.amigoscode.springboot.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.springboot.Model.Customer;
import com.amigoscode.springboot.Repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	private final CustomerRepository customers;

	public CustomerController(CustomerRepository customersRepo) {
		customers = customersRepo;
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customers.findAll();
	}
	
	record NewCustomerRequest(
			String name,
			String email,
			Integer age
			){}
	
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customers.save(customer);
	}
}
