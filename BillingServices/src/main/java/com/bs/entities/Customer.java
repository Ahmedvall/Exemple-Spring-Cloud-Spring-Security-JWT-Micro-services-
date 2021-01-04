package com.bs.entities;

public class Customer {

	private Long idC;
	private String name;
	private String email;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Long getIdC() {
		return idC;
	}

	public void setIdC(Long idC) {
		this.idC = idC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
