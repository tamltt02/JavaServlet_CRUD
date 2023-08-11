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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.poly.model.CategoryDTO;
import com.poly.model.HeoDTO;
import com.poly.model.HeoDTOForm;
import com.poly.service.ICategorySerrvice;
import com.poly.service.IHeoService;
import com.poly.utils.UploadFileUtil;

@Controller
@RequestMapping(value = "/heo")
public class HeoController {
	@Autowired
	private IHeoService service;
	@Autowired
	private ICategorySerrvice cateService;
	@Autowired
	private UploadFileUtil uploadFile;
      @GetMapping("/index")
      public String index(Model model,
    		  @RequestParam(value = "fiel",required = false) String fiel,
    		  @RequestParam(value = "direction",required = false) String direction,
    		  @RequestParam(value = "page" ,required = false) Integer page,
    		  @RequestParam(value = "name" ,required = false) String name) {
    	 
    	 Page<HeoDTO> pageData = this.service.getpage(direction,fiel,page,name);
    	 model.addAttribute("items",pageData);
    	 model.addAttribute("name",name);
    	 model.addAttribute("fiel",fiel);
    	 model.addAttribute("direction",direction);
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSP.jsp");
    	  return "Amin/index";
      }

      @GetMapping("/create")
      public String create(Model model,@ModelAttribute("productDTO") HeoDTOForm product
    		) {
    	  List<CategoryDTO> list = this.cateService.getAll();
    	model.addAttribute("categories",list);
    	model.addAttribute("save","store");
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
    	  return "Amin/index";
      }
      @GetMapping("/edit/{id}")
      public String edit(Model model,@ModelAttribute("productDTO") HeoDTOForm product,@PathVariable("id") Integer id
    		) {
    	  HeoDTO dto = this.service.findByID(id);
    	  List<CategoryDTO> list = this.cateService.getAll();
      	model.addAttribute("categories",list);
    	model.addAttribute("productDTO",dto);
    	model.addAttribute("save","update");
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
    	  return "Amin/index";
      }
      @GetMapping("/delete/{id}")
      public String delete(@PathVariable("id") Integer id
    		) {
    	 service.delete(id);
    	  return "redirect:/heo/index";
      }
      
      @PostMapping("/store")
      public String store(Model model,
    		  @Valid @ModelAttribute("productDTO") HeoDTOForm productdto,
    		 BindingResult result
    		) {
    	  
    	  
System.out.println(productdto.getImage().isEmpty());
    	  if(result.hasErrors()) {
    	    	System.out.println(result.hasErrors());
    		  List<CategoryDTO> list = this.cateService.getAll();
    	      	model.addAttribute("categories",list);
    		  model.addAttribute("save","store");
    		  System.out.println(result.getAllErrors());
    		  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
        	  return "Amin/index";
    	  }else if(productdto.getImage().isEmpty()) {
    		  List<CategoryDTO> list = this.cateService.getAll();
  	      	model.addAttribute("categories",list);
  		  model.addAttribute("save","store");
    		  model.addAttribute("imageNull","Image khong de trong");
    		  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
        	  return "Amin/index";
    	  }else {
  		      this.uploadFile.UploadFile(productdto.getImage());
  		    
    		  this.service.save(productdto);
    		  
    	  }
    	  return "redirect:/heo/index";
      }
            @PostMapping("/update")
      public String update(Model model,
    		 @Valid @ModelAttribute("productDTO") HeoDTOForm productdto,
    		 BindingResult result
    		) {
            	System.out.println(productdto.getImage().getOriginalFilename() + " " + productdto.getId());
    	  if(result.hasErrors()) {
    		  productdto.getImage().getOriginalFilename();
    		  
    		  System.out.println(result.getAllErrors());
    		  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
        	  return "Amin/index";
    	  }
    	  else {
    		  System.out.println(productdto.getImage().isEmpty());
  		     if(!productdto.getImage().isEmpty()) {
  		    	 this.uploadFile.UploadFile(productdto.getImage());
  		     }
    		  this.service.update(productdto);
    		  
    	  }
    	  return "redirect:/heo/index";
      }
}
