package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BO.Merchant_SignInBO;
import com.app.BO.User_SignInBO;
import com.app.DAO.SignInDAO;
import com.app.DAO.SignInMerchantDAO;
import com.app.DTO.Merchant_SignIn;
import com.app.DTO.User_SignIn;

@Service
public class SignInMerchantService {

	@Autowired
	SignInMerchantDAO dao;

	public boolean signInMerchant(Merchant_SignIn signIn) throws Exception {
		Merchant_SignInBO bo = new Merchant_SignInBO();
		bo.setMerchant(signIn.getMerchant());
		bo.setUserName(signIn.getUserName());
		bo.setPassword(signIn.getPassword());

		return dao.createMerchant(bo);
	}

}
