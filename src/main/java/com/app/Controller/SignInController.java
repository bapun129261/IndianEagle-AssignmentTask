package com.app.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Beans.Customer;
import com.app.Beans.User_Address;
import com.app.DTO.User_SignIn;
import com.app.Service.SignInService;

@Controller
public class SignInController {
	@Autowired
	SignInService sevice;

	@GetMapping("/signin")
	public ModelAndView signIn(HttpServletRequest req) {
		User_SignIn signIn = new User_SignIn();
		Customer customer = new Customer();
		User_Address address = new User_Address();
		String page = "";
		address.setDistrict(req.getParameter("district"));
		address.setRoadNo(Integer.parseInt(req.getParameter("road")));
		address.setState(req.getParameter("state"));

		customer.setAddress(address);
		customer.setName(req.getParameter("name"));
		customer.setPhone(Long.parseLong(req.getParameter("phone")));

		signIn.setCustomer(customer);
		signIn.setUserName(req.getParameter("username"));
		signIn.setPassword(req.getParameter("password"));
		try {
			page = sevice.signInUser(signIn) ? "home.jsp" : "error.jsp";
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}

		return new ModelAndView(page);
	}

}
