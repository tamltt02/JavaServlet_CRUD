package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Heo;
import com.poly.entity.OrderDetail;
import com.poly.mapper.OrderDetailMapper;
import com.poly.model.OrderDetailDTO;
import com.poly.repository.IOrderDetailRepository;
import com.poly.service.IOrderDetailService;
@Service
public class OrderDetailService implements IOrderDetailService{
@Autowired
private OrderDetailMapper mapper;
@Autowired
private IOrderDetailRepository repository;
	@Override
	public OrderDetailDTO save(OrderDetailDTO dto) {
		dto.setId(null);
		OrderDetail o = mapper.orderDetailConvertToEntity(dto);
		o =  this.repository.save(o);
		return this.mapper.orderConvertToDTO(o);
	}

}
