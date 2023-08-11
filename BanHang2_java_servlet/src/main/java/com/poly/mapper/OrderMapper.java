package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Order;
import com.poly.model.OrderDTO;

@Service
public class OrderMapper {
	@Autowired
	private ModelMapper mapper;
	public Order orderConvertToEntity(OrderDTO dto){
		Order o = this.mapper.map(dto, Order.class);
		return o;
	}
	public OrderDTO orderConvertToDTO(Order o){
		OrderDTO dto = this.mapper.map(o, OrderDTO.class);
		return dto;
	}
}
