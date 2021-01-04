package com.bs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date billingDate;
	private Long idC;
	
	@OneToMany(mappedBy = "bill")
	private List<ProductItem> productItems;
	
	@Transient private Customer customer;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Bill(Date billingDate, Long idC) {
		super();
		this.billingDate = billingDate;
		this.idC = idC;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getIdC() {
		return idC;
	}

	public void setIdC(Long idC) {
		this.idC = idC;
	}
	
	
	
}
