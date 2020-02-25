package com.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.BO.Merchant_Add_ProductBO;

@Repository
public class MerchantAddProductDAOProvider implements MerchantAddProduct {
	private static final String ADD_PRODUCT = "INSERT INTO PRODUCT(NAME,QUTANTITY,PRICE,MERCHANT_ID) VALUES(?,?,?,?) ";
	private static final String GET_MERCHANT_ID = "SELECT MERCHANT_ID FROM MERCHANT_LOGIN WHERE USERNAME=?";
	@Autowired
	private DataSource ds;

	@Override
	public boolean addProduct(Merchant_Add_ProductBO bo) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		boolean flag = false;
		int count = 0;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				ps = con.prepareStatement(ADD_PRODUCT.toLowerCase());
			}
			if (ps != null) {
				ps.setString(1, bo.getName());
				ps.setInt(2, bo.getQuantity());
				ps.setFloat(3, bo.getPrice());
				ps.setInt(4, getMerchantId(bo.getUsername()));
				count = ps.executeUpdate();
				if (count > 0) {
					flag = true;
				} else {
					flag = false;
				}

			}

		} catch (Exception e) {
			flag = false;
//			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

		}
		return flag;
	}

	private int getMerchantId(String userName) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				ps = con.prepareStatement(GET_MERCHANT_ID.toLowerCase());
			}
			if (ps != null) {
				ps.setString(1, userName);
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					return rs.getInt(1);
				}

			}

		} catch (Exception e) {
//			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

		}
		return 0;
	}

}
