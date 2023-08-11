package com.poly.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.poly.entity.Heo;
import com.poly.mapper.HeoMapper;
import com.poly.model.CategoryDTO;
import com.poly.model.HeoDTO;
import com.poly.model.UserDTO;
import com.poly.model.UserDTORegister;
import com.poly.service.ICategorySerrvice;
import com.poly.service.IHeoService;
import com.poly.service.IUserService;

@Controller
public class HomeController {
	@Autowired
	private IHeoService productService;
	@Autowired
	private ICategorySerrvice cateService;
	@Autowired
	private IUserService service;
	@Autowired
	private HeoMapper mapper;
	@Autowired
	private JavaMailSender sender;
   @GetMapping("/login")
    public String login(Model model,@ModelAttribute("user") UserDTORegister dto) {
	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
	   return "User/index";
   }
   @PostMapping("/login")
   public String checkLogin(Model model,@ModelAttribute("user") UserDTORegister dto,
		   @RequestParam("email") String username,
		   @RequestParam("password") String password,@RequestParam(value = "remember",defaultValue = "false") boolean remember) {
	   UserDTO check = this.service.checklogin(username, password, remember);


	   if(check != null) {
		   return  "redirect:/trangchu";
	   }
	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
   	return "User/index";  
   }
    @PostMapping("/register")
    public String register(Model model,@Valid @ModelAttribute("user") UserDTORegister dto,
    		BindingResult result) {
    	 if(result.hasErrors()) {
    		 System.out.println(result.getAllErrors());
    		
    	 }else if(!dto.getPassword().equals(dto.getConfirmPassword())) {
    		 model.addAttribute("confirmPassword","Mat khau xac nhan khong chinh xac");
    	 }else if(!service.checkEmailforgot(dto.getEmail())) {
    		 model.addAttribute("email","Email da ton tai");
    	 }else {
    		 this.service.register(dto);
    		 model.addAttribute("alert","Đăng ký thành công");
    	 }
    	 model.addAttribute("view","/WEB-INF/View/User/login.jsp");
    	return "User/index";
    }
   @GetMapping("/trangchu")
   public String index(Model model) {
	   List<HeoDTO> heos = this.productService.featuredHeo();
	   model.addAttribute("featured",heos);
	   model.addAttribute("recent", this.productService.getRecent());
	   model.addAttribute("view","/WEB-INF/View/User/trangchu.jsp");
	   return "User/index";
   }
  @GetMapping("/heo-list")
   public String product(Model model,@RequestParam(value = "name",required = false) String name,
		   @RequestParam(value = "fiel",required = false) String fiel,
		   @RequestParam(value = "min",required = false) BigDecimal min,
		   @RequestParam(value = "max",required = false) BigDecimal max,
		   @RequestParam(value = "page",required = false) Integer page,
		   @RequestParam(value = "category",required = false) String category
		   ) {
	 if(name != null || (fiel == null && min == null && max == null )) {
		 Page<HeoDTO> list =  this.productService.getpage("desc", fiel, page,name);
		
		  model.addAttribute("heos",list);
	 }else if(fiel != null){
		 Page<HeoDTO> list =  this.productService.getpage("desc", fiel, page,"");
		  model.addAttribute("heos",list);
	 }else if(min != null ) {
		 Page<HeoDTO> list =  this.productService.getPrice(min, max);
			
		  model.addAttribute("heos",list);
	 } 
	 List<CategoryDTO> categories = this.cateService.getAll();
	 model.addAttribute("categories",categories);
	 List<HeoDTO> heosByC  = this.productService.getProductByCategory(category);
	 model.addAttribute("heoC",heosByC);
	 model.addAttribute("view","/WEB-INF/View/User/product-list.jsp");
	   return "User/product-list";
   }
    @GetMapping("/heo-detail/{id}")
    public String detail(Model model,@PathVariable("id") Heo h) {
    	HeoDTO dto = mapper.convertToDTO(h);
        model.addAttribute("heo",dto);
        List<HeoDTO> list = this.productService.getProductByCategory(dto.getCategory().getName());
        model.addAttribute("related",list);
    	return "User/product-detail";
    	
    }
    @PostMapping("/forgot-password")
    public String forgotpassword(Model model,@RequestParam("emailforgot") String emailforgot,@ModelAttribute("user") UserDTORegister dto) {
    	if(this.service.checkEmailforgot(emailforgot)) {
    		model.addAttribute("forgotmail","Email không chính xác");
    	}else {
    		SimpleMailMessage ms = new SimpleMailMessage();
    		ms.setSubject("E-SHOP QUÊN MẬT KHẨU");
    		ms.setTo(emailforgot);
    		String newPass = this.service.getPasswordForgot(emailforgot);
    		ms.setText("Mật khẩu mới của bạn là : " + newPass);
    		sender.send(ms);
    		model.addAttribute("alert","Mat khau moi da duoc gui ve mail");
    	}
    	   model.addAttribute("view","/WEB-INF/View/User/login.jsp");
    	   return "User/index";
    	
    }
 
}
