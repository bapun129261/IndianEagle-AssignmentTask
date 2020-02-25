package com.app.DAO;

import org.springframework.stereotype.Repository;

import com.app.BO.Merchant_SignInBO;

@Repository
public interface SignInMerchantDAO {

	public boolean createMerchant(Merchant_SignInBO bo) throws Exception;

}
