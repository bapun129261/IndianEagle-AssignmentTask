package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BO.LoginBO;
import com.app.BO.MerchantLoginBO;
import com.app.DAO.Login;
import com.app.DAO.MerchantLogin;
import com.app.DTO.Merchant_login;
import com.app.DTO.User_login;

@Service
public class MerchantLoginService {
	@Autowired
	MerchantLogin dao;

	public int checkLoginCredential(Merchant_login login) throws Exception {
		MerchantLoginBO bo = new MerchantLoginBO();
		bo.setPassword(login.getPassword());
		bo.setUserName(login.getPassword());

		return dao.validateMercahnt(bo);
	}
}
