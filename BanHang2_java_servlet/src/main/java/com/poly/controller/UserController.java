package com.poly.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.model.UserDTO;
import com.poly.model.UserDTOForm;
import com.poly.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	private IUserService service;
     public UserController(IUserService result) {
		// TODO Auto-generated constructor stub
    	 this.service = result;
	}
	@GetMapping("/login")
	public String login() {
		return "User/cart";
	}

	@GetMapping("/home")
	public String home() {
		return "";
	}

	@GetMapping("/index")
	public String index(Model model, @ModelAttribute("user") UserDTOForm userdto,
			@RequestParam(value = "fiel", required = false) String fiel,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "name", required = false) String name) {
		Page<UserDTO> pageData = this.service.getPage(direction, fiel, page, name);
		model.addAttribute("items", pageData);
		model.addAttribute("name", name);
		model.addAttribute("fiel", fiel);
		model.addAttribute("direction", direction);
		model.addAttribute("view", "/WEB-INF/View/Amin/QLUser.jsp");
		return "Amin/index";
	}

	@PostMapping("/store")
	public String store(Model model, @Valid @ModelAttribute("user") UserDTOForm userdto, BindingResult result) {
		System.out.println(userdto.getEmail());
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			System.out.println("lôi");
			model.addAttribute("save", "store");
			model.addAttribute("view", "/WEB-INF/View/Amin/QLUserForm.jsp");
			return "Amin/index";
		} else if (!service.checkEmailforgot(userdto.getEmail())) {
			model.addAttribute("email", "Email da ton tai");
			model.addAttribute("save", "store");
			model.addAttribute("view", "/WEB-INF/View/Amin/QLUserForm.jsp");
			return "Amin/index";
		}

		else {
			this.service.insert(userdto);
			return "redirect:/user/index";
			
		}

	}

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("user") UserDTOForm dto) {
		model.addAttribute("view", "/WEB-INF/View/Amin/QLUserForm.jsp");
		model.addAttribute("save", "store");
		return "Amin/index";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		UserDTOForm dto = this.service.findbyID(id);
		model.addAttribute("user", dto);
		model.addAttribute("view", "/WEB-INF/View/Amin/QLUserForm.jsp");
		model.addAttribute("save", "update");
		return "Amin/index";
	}

	@PostMapping("/update")
	public String update(Model model, @ModelAttribute("user") UserDTOForm userdto) {
		this.service.update(userdto);
		return "redirect:/user/index";
	}

	@PostMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Integer id) {
		this.service.delete(id);
		return "redirect:/user/index";
	}

}
