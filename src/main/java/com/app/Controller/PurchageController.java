package com.app.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PurchageController {
	@PostMapping("purchage")
	public ModelAndView purchage(HttpServletRequest req) {
		return new ModelAndView("home.jsp");
	}

}
