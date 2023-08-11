package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.poly.entity.Order;
import com.poly.model.OrderDTO;

public interface IOrderService {
     OrderDTO save(OrderDTO dto);
     Page<OrderDTO> order(Integer page);
     OrderDTO delete(Integer id);
     List<OrderDTO> getsatus(Integer status);
     OrderDTO changesatus(Order o);
}
