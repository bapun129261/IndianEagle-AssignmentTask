package com.app.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.BO.User_SignInBO;

@Repository
public interface SignInDAO {

	public boolean createUser(User_SignInBO bo) throws Exception;

}
