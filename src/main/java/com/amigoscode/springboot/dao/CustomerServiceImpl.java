package com.amigoscode.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoscode.springboot.model.Customer;
import com.amigoscode.springboot.records.NewCustomerRequest;
import com.amigoscode.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	
	private final CustomerRepository customerRepo;

	@Autowired //unnecessary for a single constructor definition in this Spring bean
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}
	
	public void addCustomer(Customer customer) {
		Optional<Customer> customerByEmail = customerRepo.findCustomerByEmail(customer.getEmail());
		if(customerByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		//add Customer if email is not taken
		customerRepo.save(customer);
	}
	
	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
	}
	
	public void updateCustomer(Customer customer) {
		//customerRepo.findCustomerByName(customer.getName());
		//Customer newCustomer = customerRepo.findById(id);
		//customerRepo.save(newCustomer);
	}
}
