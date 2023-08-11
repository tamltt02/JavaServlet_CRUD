package com.poly.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.poly.entity.Category;
import com.poly.mapper.CategoryMapper;
import com.poly.model.CategoryDTO;
import com.poly.repository.ICategoryRepositoty;
import com.poly.service.ICategorySerrvice;
@Service
public class CategoryServiceimpl implements ICategorySerrvice {
    @Autowired
    private ICategoryRepositoty repository;
    @Autowired 
    private CategoryMapper mapper;
	@Override
	public Page<CategoryDTO> getPage(String direction,String fiel,Integer page,String name) {
		String fielEntity = fiel != null ? fiel : "id";
		Integer pageParam = page != null ? page - 1 : 0;
		Sort sort = (direction == null || direction.equals("asc")) ? Sort.by(Direction.ASC, fielEntity)
				: Sort.by(Direction.DESC, fielEntity);
		Pageable pageable = PageRequest.of(pageParam, 5, sort);
		Page<Category> pageData = repository.findByName(name == null ? "" : name,pageable);	
		return pageData.map(t -> mapper.convertToDTO(t) );
	}

	@Override
	public List<CategoryDTO> getAll() {
		List<Category> list  = this.repository.findAll();
		return list.stream().map(t -> mapper.convertToDTO(t) ).collect(Collectors.toList());
	}


	@Override
	public int getTotalPage() {
		double pagecount =  Math.ceil((double)this.repository.count()/5);
		return  (int)pagecount;
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Category c = this.mapper.convertToEntity(categoryDTO);
		
		 this.repository.save(c);
		return mapper.convertToDTO(c);
	}

	@Override
	public CategoryDTO delete(Integer id) {
		Optional<Category> h = this.repository.findById(id);
		
			this.repository.deleteById(id);
	
			return mapper.convertToDTO(h.get());
		
		
	}


	
 
}
