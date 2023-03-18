package com.amigoscode.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = "com.amigoscode.springboot"
//@EnableAutoConfiguration
//@Configuration
@RestController
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	/*
	@GetMapping("/")
	public String greet() {
		return "Hello";
	}
	*/
	@GetMapping("/")
	public GreetResponse greet() {
		return new GreetResponse(
				"Hello",
				List.of("Java", "Python", "JavaScript"),
				new Person("Sov", 28, 50_000)
				);
	}
	
	record GreetResponse(
			String greet,
			List<String> favProgrammingLanguage,
			Person person
			){
		
	}
	record Person(String name, int age, double savings){
		
	}
}
