package com.app.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.DTO.Merchant_add_product;
import com.app.Service.MerchantAddProductService;

@Controller
public class MerchantAddProductController {
	@Autowired
	MerchantAddProductService service;

	@PostMapping("/add")
	public ModelAndView addProduct(HttpServletRequest req) {
		String page = null;
		String error = null;

		Merchant_add_product dto = new Merchant_add_product();
		dto.setUsername(req.getParameter("username"));
		dto.setName(req.getParameter("name"));
		dto.setPrice(Float.parseFloat(req.getParameter("price")));
		dto.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		try {
			page = service.addMerchantProduct(dto) ? "forwardToMerchant_Product.jsp" : "error_Config.jsp";
		} catch (Exception e) {

			page = "error_Config.jsp";
			error = e.getMessage();
			System.out.println(error);
			return new ModelAndView(page, "error", error);

		}
		return new ModelAndView(page);
	}
}
