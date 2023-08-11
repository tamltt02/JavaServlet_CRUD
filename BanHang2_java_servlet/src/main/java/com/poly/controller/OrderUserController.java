package com.poly.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.poly.model.OrderDTO;
import com.poly.model.UserDTOchangeInfor;
import com.poly.service.IOrderService;
import com.poly.service.IUserService;

@Controller
public class OrderUserController {
	@Autowired
	private IUserService service;
	@Autowired
	private IOrderService orderService;
     @GetMapping("/myAccount")
     public String myAccount(Model model,@RequestParam(value = "page",required = false,defaultValue = "1") Integer page) {
    	 if(!service.checkCartLogin()) {
    		 return "redirect:/login";
    	 }
    	 Page<OrderDTO> list = orderService.order(page-1);
    	 list.stream().mapToDouble(t -> (t.getId() * 3) ).sum();
    	 model.addAttribute("orders",list);
    	 UserDTOchangeInfor user = this.service.getUser();
    	 model.addAttribute("userInfor",user);
    	 model.addAttribute("view","/WEB-INF/View/User/my-account.jsp");
    	 return "User/index";
     }
     @GetMapping("/logout")
     public String logout() {
    	 this.service.logout();
    	 return "redirect:/trangchu";
     }
     @GetMapping("/deleteOrder/{id}")
     public String deleteOder(Model model,@PathVariable("id") Integer id) {
    	 this.orderService.delete(id);
    	 return "redirect:/myAccount";
     }
     @PostMapping("/doi-mat-khau")
     public String doiMatKhau(Model model,@RequestParam("password") String password,
    		 @RequestParam("newPassword") String newPassword ,
    		 @RequestParam("passwordConfirm") String passwordConfirm) {
    	 if(!this.service.checkPassword(password)) {
    		 model.addAttribute("password","Password khong chính xác");
    	 }else if(!newPassword.equals(passwordConfirm)) {
    		 model.addAttribute("passwordConfirm","Password Confirm khong chinh xac");
    	 }else {
    		 this.service.changePassword(newPassword);
    		 model.addAttribute("alert","Doi mat khau thanh cong");
    		 
    	 }
    	 
    	 Page<OrderDTO> list = orderService.order(0);
    	 list.stream().mapToDouble(t -> (t.getId() * 3) ).sum();
    	 model.addAttribute("orders",list);
    	 UserDTOchangeInfor user = this.service.getUser();
    	 model.addAttribute("userInfor",user);
    	 model.addAttribute("view","/WEB-INF/View/User/my-account.jsp");
    	 return "User/index";
     }
     @PostMapping("/changeInfor")
     public String changInfor(Model model,@Valid @ModelAttribute("userInfor") UserDTOchangeInfor user,BindingResult result) {
    	 if(result.hasErrors()) {
    		 System.out.println(result.getAllErrors());
    		
    	 }else if(!service.checkEmail(user.getEmail())) {
    		
        	 model.addAttribute("email","Email đã tồn tại");
        	
    	 }else {
    		this.service.changInfor(user);
    		model.addAttribute("alert","Doi thong tin thanh cong");
    	
        	
    	 }
    	 
    	 Page<OrderDTO> list = orderService.order(0);
    	 list.stream().mapToDouble(t -> (t.getId() * 3) ).sum();
    	 model.addAttribute("orders",list);
    	 UserDTOchangeInfor u = this.service.getUser();
    	 model.addAttribute("user",u);
    	 model.addAttribute("view","/WEB-INF/View/User/my-account.jsp");
    	 return "User/index";
    	 
     }
}
