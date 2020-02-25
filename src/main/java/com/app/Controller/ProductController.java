package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("product")
	public ModelAndView product() throws Exception {

		return new ModelAndView("show_product.jsp", "product", service.displayAllProduct());
	}

	@PostMapping("/merchant_product")
	public ModelAndView merchantProduct() throws Exception {

		return new ModelAndView("merchant_show_product.jsp", "product", service.displayAllProduct());
	}
}
