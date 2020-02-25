package com.app.DAO;

import org.springframework.stereotype.Repository;

import com.app.BO.LoginBO;
import com.app.BO.MerchantLoginBO;

@Repository
public interface MerchantLogin {
	public int validateMercahnt(MerchantLoginBO bo) throws Exception;
}
