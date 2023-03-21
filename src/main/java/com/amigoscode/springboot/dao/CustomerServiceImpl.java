package com.amigoscode.springboot.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoscode.springboot.model.Customer;
import com.amigoscode.springboot.records.NewCustomerRequest;
import com.amigoscode.springboot.repository.CustomerRepository;

import jakarta.transaction.Transactional;

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
			throw new IllegalStateException("email is already taken: "+ customer.getEmail());
		}
		//add Customer if email is not taken
		customerRepo.save(customer);
	}
	
	public void deleteCustomer(Integer id) {
		if(!customerRepo.existsById(id)) {
			throw new IllegalStateException("student with id " + id + " does not exist.");
		}
		customerRepo.deleteById(id);
	}
	
	@Transactional
	public void updateCustomer(Integer id, String name, String email, Customer customer) {
		Customer newCustomer = customerRepo.findById(id)
				.orElseThrow(() -> new IllegalStateException(
						"customer with id " + id + " does not exist"));
		if(name != null && name.length() > 0 && !Objects.equals(name, newCustomer.getName())) {
			newCustomer.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals(email, newCustomer.getEmail())) {
			newCustomer.setEmail(email);
		}
		newCustomer.setAge(customer.getAge());
		
		//customerRepo.save(newCustomer);
	}
}
