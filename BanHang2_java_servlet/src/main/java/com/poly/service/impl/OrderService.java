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
import org.springframework.stereotype.Service;

import com.poly.entity.Heo;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.User;
import com.poly.mapper.OrderMapper;
import com.poly.model.OrderDTO;
import com.poly.model.OrderDetailDTO;
import com.poly.repository.IHeoRepository;
import com.poly.repository.IOrderDetailRepository;
import com.poly.repository.IOrderRepository;
import com.poly.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderMapper mapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private IOrderRepository repository;
	@Autowired
	private IOrderDetailRepository detailRepository;
	@Autowired
	private IHeoRepository heoRepository;

	@Override
	public OrderDTO save(OrderDTO dto) {
		dto.setId(null);
		Order o = this.mapper.orderConvertToEntity(dto);
		o = this.repository.save(o);
		return mapper.orderConvertToDTO(o);
	}

	@Override
	public Page<OrderDTO> order(Integer page) {
		User u = (User) this.request.getSession().getAttribute("user");
		Pageable pageable = PageRequest.of(page, 5);
		Page<Order> list = this.repository.getOrder(u,pageable);
		Page<OrderDTO> dtos = list.map(t ->this.mapper.orderConvertToDTO(t) );
		for (OrderDTO orderDTO : dtos) {
			BigDecimal total = new BigDecimal("0");
			for (OrderDetailDTO dto : orderDTO.getOrderDetails()) {
				long l = dto.getQuantity();
				BigDecimal quantity = new BigDecimal(l);
				BigDecimal bigDecimal = new BigDecimal((dto.getPrice().multiply(quantity)) +"");
				total = total.add(bigDecimal);
			}
			orderDTO.setTotal(total);
		
		}
		return dtos;
	}

	@Override
	public OrderDTO delete(Integer id) {
		Optional<Order> o  = this.repository.findById(id);
		if(o.isPresent()) {
			o.get().setStatus(3);
			this.repository.save(o.get());
			List<OrderDetail> list =  this.detailRepository.getByOrder(o.get());
			for (OrderDetail orderDetail : list) {
				Heo h = orderDetail.getHeo();
				h.setQuantity(h.getQuantity() + orderDetail.getQuantity());
			this.heoRepository.save(h);
			}
		}
		
		return mapper.orderConvertToDTO(o.get());
	}

	@Override
	public List<OrderDTO> getsatus(Integer status) {
	List<Order> list = this.repository.getOrderbyStatus(status);
	List<OrderDTO> dtos = list.stream().map(t ->this.mapper.orderConvertToDTO(t) ).collect(Collectors.toList());
	for (OrderDTO orderDTO : dtos) {
		BigDecimal total = new BigDecimal(0);
		for (OrderDetailDTO dto : orderDTO.getOrderDetails()) {
		
			long l = dto.getQuantity();
			BigDecimal quantity = new BigDecimal(l+"");
			
		total = 	total.add(dto.getPrice().multiply(quantity));
		}
		orderDTO.setTotal(total);
	}
	return dtos;
	}

	@Override
	public OrderDTO changesatus(Order o) {
		o.setStatus(o.getStatus() +1);
		if(o.getId() != null) {
			this.repository.save(o);
		}
		return mapper.orderConvertToDTO(o);
	}
	

}
