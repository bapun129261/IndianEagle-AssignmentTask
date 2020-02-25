package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.DTO.User_login;
import com.app.Service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String userName, @RequestParam("password") String password)
			throws Exception {
		User_login login = new User_login();
		login.setUserName(userName);
		login.setPassword(password);

		
		return new ModelAndView("forwardToProduct.jsp", "login", service.checkLoginCredential(login));
	}

}
