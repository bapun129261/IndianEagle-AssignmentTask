package com.app.BO;

import com.app.Beans.Customer;
import com.app.Beans.Merchant;

public class Merchant_SignInBO {
	Merchant merchant;
	String userName;
	String password;

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
