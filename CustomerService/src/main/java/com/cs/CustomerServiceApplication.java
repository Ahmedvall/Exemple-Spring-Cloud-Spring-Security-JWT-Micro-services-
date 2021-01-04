package com.cs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.cs.entities.Customer;
import com.cs.repository.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer("Ahmed", "ahmed@gmail.com"));
			customerRepository.save(new Customer("Khaled", "khaled@gmail.com"));
			customerRepository.save(new Customer("Ali", "ali@gmail.com"));
		};
	}

}
