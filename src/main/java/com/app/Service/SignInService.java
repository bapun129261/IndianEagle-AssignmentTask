package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BO.User_SignInBO;
import com.app.DAO.SignInDAO;
import com.app.DTO.User_SignIn;

@Service
public class SignInService {

	@Autowired
	SignInDAO dao;

	public boolean signInUser(User_SignIn signIn) throws Exception {
		User_SignInBO bo = new User_SignInBO();
		bo.setCustomer(signIn.getCustomer());
		bo.setUserName(signIn.getUserName());
		bo.setPassword(signIn.getPassword());

		return dao.createUser(bo);
	}

}
