package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.poly.model.CategoryDTO;

public interface ICategorySerrvice {
	 Page<CategoryDTO> getPage(String direction,String fiel,Integer page,String name);
	 List<CategoryDTO> getAll();
	 int getTotalPage();
	 CategoryDTO save(CategoryDTO categoryDTO);
	 CategoryDTO delete(Integer id);
	 
}
