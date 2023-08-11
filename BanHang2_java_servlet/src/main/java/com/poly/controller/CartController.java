package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.service.ICartService;
import com.poly.service.IUserService;

@Controller
public class CartController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private IUserService userService;
	   @GetMapping("/cart")
	    public String getCart(Model model) {
	    	model.addAttribute("heos",this.cartService.getCart());
	    	model.addAttribute("total",this.cartService.getTotal());
	    	System.out.println(this.cartService.getTotal());
	    	model.addAttribute("view","/WEB-INF/View/User/cart.jsp");
	    	return "User/index";
	    }
	    @GetMapping("/cart/{id}")
	    public String addToCart(Model model,@PathVariable("id") Integer id) {
	    	this.cartService.addToCart(id, 1);
	    	model.addAttribute("heos",this.cartService.getCart());
	    	
	    	return "redirect:/cart";
	    }
	    @GetMapping("/changeQuantity/{id}")
	    public String changeQuantity(Model model,@PathVariable("id") Integer id,@RequestParam("quantity") Integer quantity) {
	    	
	    	this.cartService.changeProductQuantity(id, quantity);
	       return "redirect:/cart";
	    }
	    @GetMapping("/deleteCart/{id}")
	    public String deleteCart(Model model,@PathVariable("id") Integer id) {
	    	this.cartService.removeProduct(id);
	       return "redirect:/cart";
	    }
	    @GetMapping("/deletesCart")
	    public String deletesCart(Model model) {
	    	this.cartService.removeProducts();
	       return "redirect:/cart";
	    }
	    @GetMapping("thanh-toan")
	    public String thanhToan(Model model) {
	    	if(this.userService.checkCartLogin() == false) {
	    		 return "redirect:/login";
	    	}
	    	if(!this.cartService.checkCartNull()) {
	    		this.cartService.buy();
	    	}
	    
	    	  return "redirect:/cart";
	    }
	    
}
