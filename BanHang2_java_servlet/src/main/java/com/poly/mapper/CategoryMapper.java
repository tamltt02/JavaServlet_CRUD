package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Category;
import com.poly.model.CategoryDTO;

@Service
public class CategoryMapper {
   @Autowired
   private ModelMapper mapper;
   
   public CategoryDTO convertToDTO(Category category) {
	   CategoryDTO dto = mapper.map(category, CategoryDTO.class);
	   return dto;
   }
   public Category convertToEntity(CategoryDTO dto) {
	   Category category = mapper.map(dto, Category.class);
	   return category;
   }
}
