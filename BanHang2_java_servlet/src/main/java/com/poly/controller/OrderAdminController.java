package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.entity.Order;
import com.poly.model.OrderDTO;
import com.poly.service.IOrderService;

@Controller
public class OrderAdminController {
@Autowired
private IOrderService service;
	@GetMapping("/order")
	public String index(Model model) {
		List<OrderDTO> list = this.service.getsatus(0);
		model.addAttribute("list",list);
		model.addAttribute("view","/WEB-INF/View/Amin/QLDonHang.jsp");
		return "Amin/index";
	}
	@GetMapping("/order/{id}")
	public String xacNhan(Model model,@PathVariable("id") Order o) {
	OrderDTO dto =  this.service.changesatus(o);
	switch (dto.getStatus()-1) {
	case 0:
		return "redirect:/order";
		
	case 1:
		return "redirect:/order-dang-giao";
	case 2:
		return "redirect:/order-da-giao";
		
	default:
		return "redirect:/order-da-huy";
	}
		
	} 
	
	@GetMapping("/delete-order/{id}")
	public String delete(Model model,@PathVariable("id") Integer id) {
	this.service.delete(id);
		return "redirect:/order";
	}
	
	@GetMapping("/order-dang-giao")
	public String danggiao(Model model) {
		List<OrderDTO> list = this.service.getsatus(1);
		model.addAttribute("list",list);
		model.addAttribute("view","/WEB-INF/View/Amin/QLDonHang1.jsp");
		return "Amin/index";
	}
	@GetMapping("/order-da-giao")
	public String dagiao(Model model) {
		List<OrderDTO> list = this.service.getsatus(2);
		model.addAttribute("list",list);
		model.addAttribute("view","/WEB-INF/View/Amin/QLDonHang2.jsp");
		return "Amin/index";
	}
	@GetMapping("/order-da-huy")
	public String daHuy(Model model) {
		List<OrderDTO> list = this.service.getsatus(3);
		model.addAttribute("list",list);
		model.addAttribute("view","/WEB-INF/View/Amin/QLDonHang3.jsp");
		return "Amin/index";
	}
}
