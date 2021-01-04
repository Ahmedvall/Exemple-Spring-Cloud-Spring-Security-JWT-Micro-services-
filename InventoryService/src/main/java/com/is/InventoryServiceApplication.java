package com.is;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.is.entities.Product;
import com.is.repository.ProductRepository;

@SpringBootApplication
@EnableEurekaClient
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	} 
	
	
	@Bean	
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("HP", 1100.0, 10));
			productRepository.save(new Product("MaC", 3000.3, 12));
			productRepository.save(new Product("Dell",1590.7, 20 ));
		};
	}

}
