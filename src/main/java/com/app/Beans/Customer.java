package com.app.Beans;

public class Customer {

	private String name;
	private long phone;
	private User_Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User_Address getAddress() {
		return address;
	}

	public void setAddress(User_Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
