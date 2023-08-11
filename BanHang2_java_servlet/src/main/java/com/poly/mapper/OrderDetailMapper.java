package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poly.entity.OrderDetail;
import com.poly.model.OrderDetailDTO;
@Service
public class OrderDetailMapper {
	@Autowired
	private ModelMapper mapper;
	public OrderDetail orderDetailConvertToEntity(OrderDetailDTO dto){
		OrderDetail o = this.mapper.map(dto, OrderDetail.class);
		return o;
	}
	public OrderDetailDTO orderConvertToDTO(OrderDetail o){
		OrderDetailDTO dto = this.mapper.map(o, OrderDetailDTO.class);
		return dto;
	}
}
