package com.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.BO.LoginBO;

@Repository
public class LoginDAOProvider implements Login {
	private static final String VALIDATE_USER = "SELECT CUSTOMER_ID FROM USER_LOGIN WHERE USERNAME=? AND PASSWORD=?";
	@Autowired
	private DataSource dataSource;

	@Override
	public int validateUser(LoginBO bo) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		int customerId = 0;
		con = dataSource.getConnection();
		if (con != null) {
			ps = con.prepareStatement(VALIDATE_USER.toLowerCase());
			ps.setString(1, bo.getUserName());
			ps.setString(2, bo.getPassword());

		}
		if (ps != null) {
			resultSet = ps.executeQuery();
		}
		if (resultSet != null) {
			while (resultSet.next()) {
				customerId = resultSet.getInt(1);
			}

		}
		resultSet.close();
		ps.close();
		con.close();

		return customerId;
	}

}
