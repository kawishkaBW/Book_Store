package com.bookstore.web.Controller;

import com.bookstore.model.Product;
import com.bookstore.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;
	@GetMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView search(@RequestParam("value") String value) {
		ModelAndView mv = new ModelAndView();;
		mv.setViewName("fragments/searchFragment");
		List<Product> products = productService.searchProductByNameLike(value);
		mv.addObject("products", products);
		return mv;
	}
}
