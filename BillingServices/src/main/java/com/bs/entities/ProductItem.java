package com.bs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProductItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPI;
	private Long idP;
	
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Bill bill;
	
	@Transient
	private Product product;

	public ProductItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ProductItem(Long idP, Bill bill) {
		super();
		this.idP = idP;
		this.bill = bill;
	}



	public Long getIdPI() {
		return idPI;
	}

	public void setIdPI(Long idPI) {
		this.idPI = idPI;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getIdP() {
		return idP;
	}

	public void setIdP(Long idP) {
		this.idP = idP;
	}
	
	
	
}
