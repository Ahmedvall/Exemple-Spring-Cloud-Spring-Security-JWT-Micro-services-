package com.bs.entities;

public class Product {

	private Long idP;
	private String name;
	private double price;
	private int quantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Long getIdP() {
		return idP;
	}
	public void setIdP(Long idP) {
		this.idP = idP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
