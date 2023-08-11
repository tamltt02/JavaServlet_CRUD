package com.poly.mapper;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Heo;
import com.poly.model.HeoDTO;
import com.poly.model.HeoDTOForm;

@Service
public class HeoMapper {
      
	@Autowired
	private ModelMapper mapper;
	
	public Heo convertToEntity(HeoDTO dto) {
		Heo p = mapper.map(dto, Heo.class);
		return p;
	}
	public HeoDTO convertToDTO(Heo p) {
		HeoDTO dto = mapper.map(p, HeoDTO.class);
		
		return dto;
	}
	public Heo convertToEntityForm(HeoDTOForm dto) {
		Heo p = mapper.map(dto, Heo.class);
		p.setImage(dto.getImage().getOriginalFilename());
		p.setCreateDate(new Date());
		return p;
	}
	public HeoDTOForm convertToDTOForm(Heo p) {
		HeoDTOForm dto = mapper.map(p, HeoDTOForm.class);
		
		return dto;
	}
}
