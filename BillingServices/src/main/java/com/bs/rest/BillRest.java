package com.bs.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bs.entities.Bill;
import com.bs.proxies.CustomerClient;
import com.bs.proxies.ProductClient;
import com.bs.repository.BillRepository;

@RestController
public class BillRest {
	
	@Autowired BillRepository billRepository;
	@Autowired CustomerClient customerClient;
	@Autowired ProductClient productClient;
	
	@GetMapping("/bills")
	@PostAuthorize("hasAuthority('USER')")
	public List<Bill> getBills() {
		List<Bill> bills = new ArrayList<>();
		bills = billRepository.findAll();
		
		for (Bill bill : bills) {
			bill.setCustomer(customerClient.getCustomerById(bill.getIdC()));
			bill.getProductItems().forEach(pi->{
				pi.setProduct(productClient.getProductById(pi.getIdP()));
			});
		}
		
		return bills;
	}
	
	
	@GetMapping("/bills/{id}")
	public Bill getBill(@PathVariable Long id) {
		return billRepository.findById(id).get();
	}

}
