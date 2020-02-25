package com.app.DAO;

import org.springframework.stereotype.Repository;

import com.app.BO.LoginBO;

@Repository
public interface Login {
	public int validateUser(LoginBO bo) throws Exception;
}
