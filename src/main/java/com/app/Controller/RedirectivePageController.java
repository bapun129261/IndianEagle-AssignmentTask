package com.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("e-commerce")
public class RedirectivePageController {

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index.jsp");
	}

	@GetMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home.jsp");
	}

	@GetMapping("/merchant")
	public ModelAndView merchantHome() {
		return new ModelAndView("merchant_home.jsp");
	}

	@GetMapping("/additems")
	public ModelAndView addItems() {
		return new ModelAndView("merchant_add_item.jsp");
	}

}
