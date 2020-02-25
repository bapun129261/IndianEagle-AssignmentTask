package com.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.BO.Merchant_SignInBO;
import com.app.BO.User_SignInBO;

@Repository
public class SignInMerchantDAOProvider implements SignInMerchantDAO {
	private static final String INSERT_MERCHANT = "INSERT INTO MERCHANT(NAME,PHONE,ADDRESS_ID) VALUES (?,?,?)";
	private static final String INSERT_ADDRESS = "INSERT INTO ECOM_ADDRESS(DISTRICT,ROADNUM,STATE) VALUES (?,?,?)";
	private static final String INSERT_MERCHANT_LOGIN = "INSERT INTO MERCHANT_LOGIN(USERNAME,PASSWORD,MERCHANT_ID) VALUES (?,?,?)";
	private static final String SELECT_ADDRESS_ID = "SELECT MAX(ID) FROM ECOM_ADDRESS";
	private static final String SELECT_CUSTOMER_ID = "SELECT MAX(ID) FROM MERCHANT";
	@Autowired
	private DataSource ds;

	@Override
	public boolean createMerchant(Merchant_SignInBO bo) throws Exception {
		boolean flag = false;
		if (insertAddress(bo) == false) {
			flag = false;
		}

		Connection con = null;
		PreparedStatement ps = null;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				ps = con.prepareStatement(INSERT_MERCHANT.toLowerCase());
				ps.setString(1, bo.getMerchant().getName());
				ps.setLong(2, bo.getMerchant().getPhone());
				ps.setInt(3, getAddressId());
				ps.executeUpdate();
				flag = true;
				if (insertUserlogIn(bo) == false) {
					flag = false;
				}

			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			throw new Exception();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

		}
		return flag;

	}

	private int getAddressId() throws Exception {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery(SELECT_ADDRESS_ID.toLowerCase());

			}
			if (rs != null) {
				while (rs.next()) {
					return rs.getInt(1);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

		}

		return 0;
	}

	private int getCustomerId() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				st = con.createStatement();
				rs = st.executeQuery(SELECT_CUSTOMER_ID.toLowerCase());

			}
			if (rs != null) {
				while (rs.next()) {
					return rs.getInt(1);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

		}

		return 0;
	}

	private boolean insertAddress(Merchant_SignInBO bo) throws Exception {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				ps = con.prepareStatement(INSERT_ADDRESS.toLowerCase());
			}
			if (ps != null) {
				ps.setString(1, bo.getMerchant().getAddress().getDistrict());
				ps.setInt(2, bo.getMerchant().getAddress().getRoadNo());
				ps.setString(3, bo.getMerchant().getAddress().getState());
				ps.executeUpdate();
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			throw new Exception();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

		}
		return flag;

	}

	private boolean insertUserlogIn(Merchant_SignInBO bo) throws Exception {
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			if (ds != null) {
				con = ds.getConnection();
			}
			if (con != null) {
				ps = con.prepareStatement(INSERT_MERCHANT_LOGIN.toLowerCase());
			}
			if (ps != null) {
				ps.setString(1, bo.getUserName());
				ps.setString(2, bo.getPassword());
				ps.setInt(3, getCustomerId());
				ps.executeUpdate();
				flag = true;

			}

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			throw new Exception();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new Exception();
				}
			}

		}
		return flag;

	}

}
