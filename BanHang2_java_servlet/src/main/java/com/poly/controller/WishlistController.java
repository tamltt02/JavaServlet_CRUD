package com.poly.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.model.HeoDTO;
import com.poly.service.IWishlist;

@Controller
public class WishlistController {
	@Autowired
	private IWishlist service;
 @GetMapping("/wishlist")
 public String index(Model model) {
List<HeoDTO> list = service.getCart();
	
	 model.addAttribute("wish",list);
	 model.addAttribute("view","/WEB-INF/View/User/wishlist.jsp");
	 return "User/index";
 }
 @GetMapping("/wishlist/{id}")
 public String index(Model model,@PathVariable("id") Integer id) {
	this.service.addToWishlist(id);
	 return "redirect:/wishlist";
 }
 @GetMapping("/deleteWishlist/{id}")
 public String delete(Model model,@PathVariable("id") Integer id) {
	this.service.removeProduct(id);
	 return "redirect:/wishlist";
 }
 
}
