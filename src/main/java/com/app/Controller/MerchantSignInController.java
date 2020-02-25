package com.app.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Beans.Merchant;
import com.app.Beans.User_Address;
import com.app.DTO.Merchant_SignIn;
import com.app.Service.SignInMerchantService;

@Controller
public class MerchantSignInController {
	@Autowired
	SignInMerchantService sevice;

	@GetMapping("/merchant_signin")
	public ModelAndView signIn(HttpServletRequest req) {
		Merchant_SignIn signIn = new Merchant_SignIn();
		Merchant merchant = new Merchant();
		User_Address address = new User_Address();
		String page = "";
		address.setDistrict(req.getParameter("district"));
		address.setRoadNo(Integer.parseInt(req.getParameter("road")));
		address.setState(req.getParameter("state"));

		merchant.setAddress(address);
		merchant.setName(req.getParameter("name"));
		merchant.setPhone(Long.parseLong(req.getParameter("phone")));

		signIn.setMerchant(merchant);
		signIn.setUserName(req.getParameter("username"));
		signIn.setPassword(req.getParameter("password"));
		try {
			page = sevice.signInMerchant(signIn) ? "home.jsp" : "error.jsp";
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}

		return new ModelAndView(page);
	}

}
