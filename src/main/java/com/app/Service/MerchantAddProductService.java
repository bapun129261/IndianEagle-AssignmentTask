package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BO.Merchant_Add_ProductBO;
import com.app.DAO.MerchantAddProduct;
import com.app.DTO.Merchant_add_product;

@Service
public class MerchantAddProductService {
	@Autowired
	MerchantAddProduct dao;

	public boolean addMerchantProduct(Merchant_add_product dto) throws Exception {
		Merchant_Add_ProductBO bo = new Merchant_Add_ProductBO();
		bo.setName(dto.getName());
		bo.setPrice(dto.getPrice());
		bo.setQuantity(dto.getQuantity());
		bo.setUsername(dto.getUsername());
		return dao.addProduct(bo);

	}

}
