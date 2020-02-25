package com.app.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.Beans.AllProduct;
@Repository
public interface Product {
	public List<AllProduct> retriveAllProduct() throws Exception;

}
