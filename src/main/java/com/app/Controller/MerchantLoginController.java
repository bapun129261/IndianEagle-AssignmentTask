package com.app.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.app.DTO.Merchant_login;
import com.app.DTO.User_login;
import com.app.Service.LoginService;
import com.app.Service.MerchantLoginService;

@Controller

public class MerchantLoginController {
	@Autowired
	MerchantLoginService service;

	@PostMapping("/merchant_login")
	public ModelAndView login(@RequestParam("username") String userName, @RequestParam("password") String password,
			HttpServletRequest req) throws Exception {
		Merchant_login login = new Merchant_login();
		login.setUserName(userName);
		login.setPassword(password);
		service.checkLoginCredential(login);
		req.getSession().setAttribute("login", login.getUserName());

		return new ModelAndView("forwardToMerchant_Product.jsp");
	}

}
