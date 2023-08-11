package com.poly.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.poly.entity.Heo;
import com.poly.mapper.HeoMapper;
import com.poly.model.HeoDTO;
import com.poly.model.HeoDTOForm;
import com.poly.repository.IHeoRepository;
import com.poly.service.IHeoService;

@Service
public class HeoServiceIML implements IHeoService {
	@Autowired
	private IHeoRepository repository;

	@Autowired
	private HeoMapper mapper;
	@Autowired
	private HttpServletRequest request;

	@Override
	public Page<HeoDTO> getpage(String direction, String fiel, Integer page, String name) {
		fiel = fiel != null ? fiel : "id";
		page = page != null ? page - 1 : 0;
		Sort sort = (direction == null || direction.equals("asc")) ? Sort.by(Direction.ASC, fiel)
				: Sort.by(Direction.DESC, fiel);
		Pageable pageable = PageRequest.of(page, 9, sort);
		Page<Heo> data = this.repository.getByName(name == null ? "" : name, pageable);
		return data.map(t -> mapper.convertToDTO(t));
	}

	@Override
	public int pagetotal() {
		int pagecount = (int) Math.ceil((double) this.repository.count() / 5);
		return pagecount;
	}

	@Override
	public HeoDTO save(HeoDTOForm productdto) {
		Heo product = this.mapper.convertToEntityForm(productdto);
		product.setId(null);
		product = repository.save(product);
		return mapper.convertToDTO(product);
	}
	@Override
	public HeoDTO findByID(Integer id) {
		Optional<Heo> h = this.repository.findById(id);
		if(h.isPresent()) {
			HeoDTO dto = mapper.convertToDTO(h.get());
			return dto;
		}
		return null;
	}

	@Override
	public HeoDTO update(HeoDTOForm productdto) {
		Heo product = this.mapper.convertToEntityForm(productdto);
		System.out.println(product.getImage());
		if(product.getImage().equals("")) {
			product.setImage(this.repository.findById(product.getId()).get().getImage());
		}
	if(this.repository.findById(product.getId()) != null) {
		product = repository.save(product);
		request.getSession().setAttribute("message", "Cập nhật thành công");
		return mapper.convertToDTO(product);
	}
	return null;
	}

	@Override
	public List<HeoDTO> featuredHeo() {
		List<Heo> list = this.repository.findAll();
		return list.stream().
				sorted((h1,h2) -> ((Integer) h2.getOrderDetails().size()).compareTo((Integer) h1.getOrderDetails().size()))
				.map(t -> mapper.convertToDTO(t)).collect(Collectors.toList());
	}

	@Override
	public List<HeoDTO> getRecent() {
		Pageable pageable = PageRequest.of(0, 5);
		List<Heo> list = this.repository.getRecent(pageable);
		return list.stream().map(t ->  mapper.convertToDTO(t)).collect(Collectors.toList());
	}

	@Override
	public Page<HeoDTO> getPrice(BigDecimal min, BigDecimal max) {
		Page<Heo> list = this.repository.findPrice(min, max,PageRequest.of(0, 40));
		return list.map(t -> mapper.convertToDTO(t));
	}

	@Override
	public List<HeoDTO> getProductByCategory(String category) {
		if(category ==  null) category = "";
	     List<Heo> list = this.repository.findProductByCategory(category);
		return list.stream().map(t ->mapper.convertToDTO(t) ).collect(Collectors.toList());
	}

	@Override
	public HeoDTO delete(Integer id) {
		Optional<Heo> heo = this.repository.findById(id);
		if(heo.isPresent())
		this.repository.deleteById(id);
		return mapper.convertToDTO(heo.get());
	}



}
