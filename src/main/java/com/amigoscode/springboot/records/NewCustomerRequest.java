package com.amigoscode.springboot.records;

public record NewCustomerRequest(
		String name,
		String email,
		Integer age
		){}