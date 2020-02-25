package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Beans.AllProduct;
import com.app.DAO.Product;

@Service
public class ProductService {
	@Autowired
	Product product;

	public List<AllProduct> displayAllProduct() throws Exception {

		return product.retriveAllProduct();

	}
}
