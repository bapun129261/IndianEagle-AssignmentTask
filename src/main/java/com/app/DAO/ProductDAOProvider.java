package com.app.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.Beans.AllProduct;

@Repository
public class ProductDAOProvider implements Product {
	private static final String GET_ALL_PRODUCT = "SELECT * FROM PRODUCT";
	@Autowired
	DataSource ds;

	@Override
	public List<AllProduct> retriveAllProduct() throws Exception {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<AllProduct> product = new ArrayList<>();

		con = ds.getConnection();
		if (con != null) {
			st = con.createStatement();
		}
		if (st != null) {
			rs = st.executeQuery(GET_ALL_PRODUCT.toLowerCase());
		}
		if (rs != null) {
			AllProduct beans = null;
			while (rs.next()) {
				beans = new AllProduct();
				beans.setId(rs.getInt(1));
				beans.setName(rs.getString(2));
				beans.setQuantity(rs.getInt(3));
				beans.setPrice(rs.getFloat(4));
				product.add(beans);
			}

		}
		rs.close();
		st.close();
		con.close();

		return product;
	}

}
