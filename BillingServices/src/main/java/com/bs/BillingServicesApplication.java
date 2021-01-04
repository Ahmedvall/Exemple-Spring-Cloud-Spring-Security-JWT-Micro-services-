package com.bs;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.bs.entities.Bill;
import com.bs.entities.ProductItem;
import com.bs.repository.BillRepository;
import com.bs.repository.ProductItemRepository;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class BillingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServicesApplication.class, args);
	} 
	
	
	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository pItemRepository) {
		return args -> {
			Bill b1 = billRepository.save(new Bill(new Date(), 1L));
			Bill b2 = billRepository.save(new Bill(new Date(), 2L));
			Bill b3 = billRepository.save(new Bill(new Date(), 3L));
			pItemRepository.save(new ProductItem(1L, b1));
			pItemRepository.save(new ProductItem(2L, b2));
			pItemRepository.save(new ProductItem(3L, b3));
			
		};
	}

}
