package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BO.LoginBO;
import com.app.DAO.Login;
import com.app.DTO.User_login;

@Service
public class LoginService {
	@Autowired
	Login dao;

	public int checkLoginCredential(User_login login) throws Exception {
		LoginBO bo = new LoginBO();
		bo.setPassword(login.getPassword());
		bo.setUserName(login.getPassword());

		return dao.validateUser(bo);
	}
}
