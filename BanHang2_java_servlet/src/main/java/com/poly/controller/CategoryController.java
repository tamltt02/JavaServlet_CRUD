package com.poly.controller;




import javax.servlet.http.HttpSession;
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

import com.poly.entity.Category;
import com.poly.mapper.CategoryMapper;
import com.poly.model.CategoryDTO;
import com.poly.service.ICategorySerrvice;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	private ICategorySerrvice categoryService;
	@Autowired
	private HttpSession session;
	@Autowired
	private CategoryMapper mapper;

	@GetMapping("/index")
	public String getIndex(Model model,
			@RequestParam(value = "direction",required = false) String direction,
			@ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			@RequestParam(value = "fiel",required = false) String fiel,
			@RequestParam(value = "page",required = false) Integer page,
			@RequestParam(value = "name",required = false) String name
			) {
		
		Page<CategoryDTO> pageData = categoryService.getPage(direction,fiel,page,name);

		model.addAttribute("categories", pageData);
		model.addAttribute("pagecount", pageData.getTotalPages());
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTL.jsp");
		model.addAttribute("fiel",fiel);
		model.addAttribute("direction",direction);
		model.addAttribute("page",page);
		model.addAttribute("name",name);
		return "/Amin/index";
	}
	@GetMapping("/create")
	public String getCreate(Model model,@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
		session.setAttribute("save","store");
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
		return "/Amin/index";
	}
	@PostMapping("/store")
	public String save(Model model,
			@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			BindingResult result
			) {
		if(result.hasErrors()) {
			model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
			return "/Amin/index";
		}else {
			this.categoryService.save(categoryDTO);
			return "redirect:/category/index";
		}
		
		
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Category category) {
		CategoryDTO dto = mapper.convertToDTO(category);
		model.addAttribute("categoryDTO",dto);
		session.setAttribute("save","update");
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
		return "/Amin/index";
	}
	@PostMapping("/update")
	public String update(Model model,
			@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			BindingResult result
			) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
			return "/Amin/index";
		}else {
			this.categoryService.save(categoryDTO);
			return "redirect:/category/index";
		}
	}
	@GetMapping("/delete/{category_id}")
	public String delete(Model model,@PathVariable("category_id") Integer id) {
		
	this.categoryService.delete(id);
		
	
		return "redirect:/category/index";
	}
	
}
