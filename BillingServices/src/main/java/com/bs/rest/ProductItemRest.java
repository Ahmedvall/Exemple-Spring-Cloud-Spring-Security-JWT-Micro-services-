package com.bs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bs.entities.ProductItem;
import com.bs.repository.ProductItemRepository;

@RestController
public class ProductItemRest {
	
	@Autowired ProductItemRepository productItemRepository;
	
	@GetMapping("/productItems")
	public List<ProductItem> getProductItems() {
		return productItemRepository.findAll();
	}
	
	
	@GetMapping("/productItems/{id}")
	public ProductItem getProductItems(@PathVariable Long id) {
		return productItemRepository.findById(id).get();
	}

}
