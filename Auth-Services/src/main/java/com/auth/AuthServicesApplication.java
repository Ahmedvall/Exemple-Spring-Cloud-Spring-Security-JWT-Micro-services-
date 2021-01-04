package com.auth;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth.entities.AppRole;
import com.auth.entities.AppUser;
import com.auth.services.AccountServiceImpl;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AuthServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServicesApplication.class, args);
	}

	
	@Bean
	PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner start(AccountServiceImpl accountService) {
		
		return args -> {
			accountService.addNewRole(new AppRole("ADMIN"));
			accountService.addNewRole(new AppRole("USER"));
			accountService.addNewRole(new AppRole("PRODUCT_MANAGER"));
			accountService.addNewRole(new AppRole("CUSTOMER_MANAGER"));
			accountService.addNewRole(new AppRole("BILLS_MANAGER"));
			
			
			accountService.addNewUSer(new AppUser("user1", "1234", new ArrayList<>()));
			accountService.addNewUSer(new AppUser("user2", "1234", new ArrayList<>()));
			accountService.addNewUSer(new AppUser("user3", "1234", new ArrayList<>()));
			accountService.addNewUSer(new AppUser("user4", "1234", new ArrayList<>()));
			accountService.addNewUSer(new AppUser("admin", "1234", new ArrayList<>()));
			
			
			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("user2", "PRODUCT_MANAGER");
			accountService.addRoleToUser("user3", "USER");
			accountService.addRoleToUser("user3", "CUSTOMER_MANAGER");
			accountService.addRoleToUser("user4", "USER");
			accountService.addRoleToUser("user4", "BILLS_MANAGER");
			accountService.addRoleToUser("admin", "USER");
			accountService.addRoleToUser("admin", "ADMIN");
			
		};
	}
}
