package com.amigoscode.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amigoscode.springboot.model.Customer;
import com.amigoscode.springboot.records.NewCustomerRequest;
import com.amigoscode.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	
	private final CustomerRepository customerRepo;

	public CustomerServiceImpl(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}


	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}
	
	public void addCustomer(NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepo.save(customer);
	}
}
