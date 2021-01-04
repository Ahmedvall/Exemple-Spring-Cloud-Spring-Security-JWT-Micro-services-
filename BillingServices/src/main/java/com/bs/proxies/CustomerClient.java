package com.bs.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bs.entities.Customer;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {
	
	@GetMapping("/customers/{id}")
	Customer getCustomerById(@PathVariable Long id);

}
