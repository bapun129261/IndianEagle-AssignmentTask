package com.app.DTO;

public class Merchant_add_product {
	String username;
	String name;
	float price;
	int quantity;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Merchant_add_product [username=" + username + ", name=" + name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

}
