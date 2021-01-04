package com.bs.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bs.entities.Product;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductClient {

	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable Long id);

	
}
