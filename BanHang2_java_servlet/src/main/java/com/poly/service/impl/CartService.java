package com.poly.service.impl;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.poly.entity.Heo;
import com.poly.entity.User;
import com.poly.mapper.HeoMapper;
import com.poly.mapper.UserMapper;
import com.poly.model.Cart;
import com.poly.model.HeoDTO;
import com.poly.model.OrderDTO;
import com.poly.model.OrderDetailDTO;
import com.poly.repository.IHeoRepository;
import com.poly.service.ICartService;
import com.poly.service.IOrderDetailService;
import com.poly.service.IOrderService;
@SessionScope
@Service
public class CartService implements ICartService {
	Map<Integer, Cart> carts = new HashMap<>();

	@Autowired
	private IHeoRepository repository;
	@Autowired
	private HeoMapper mapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private IOrderService orderService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private HeoMapper heoMapper;
	@Autowired
	private IOrderDetailService orderDetailService;


	@Override
	public void addToCart(int productId, int quantity) {
	
		int currentQuantity = 0;
		// Neu san pham chua co trong gio hang
		if (carts.containsKey(productId)) {
			// lay so luong hien co ra

			currentQuantity = carts.get(productId).getQuantity();

		}
		// cong don
		Cart cart = new Cart();
		Optional<Heo> h = this.repository.findById(productId);
		cart.setPrice(h.get().getPrice());
		cart.setHeo(mapper.convertToDTO(h.get()));
		int updatedQuantity = currentQuantity;
		if(currentQuantity < h.get().getQuantity()) {
			updatedQuantity+=quantity;
		}
		cart.setQuantity(updatedQuantity);
		carts.put(productId, cart);
		
	}

	@Override
	public void changeProductQuantity(int productId, int quantity) {
		Cart cart = carts.get(productId);
	HeoDTO dto =  cart.getHeo();
     if(quantity > dto.getQuantity()) quantity = dto.getQuantity();
     if(quantity < 0)quantity = 1;
		cart.setQuantity(quantity);
		carts.put(productId, cart);
	}

	@Override
	public void removeProduct(int productId) {
	
		carts.remove(productId);
	}

	@Override
	public void removeProducts() {
		carts.clear();;
	}

//	@Override
//	public boolean checkQuantity(HeoDTO h) {
//		if (h.getQuantity() == 0) {
//			request.getSession().setAttribute("message", "Sản phẩm số lượng bằng 0");
//			return false;
//		}
//		boolean chua = carts.containsKey(h.getId());
//		System.out.println(chua);
//		if (chua == true) {
//			int value = carts.get(h.getId()).getQuantity();
//			System.out.println(value);
//			if (h.getQuantity() <= value) {
//				request.getSession().setAttribute("message", "Số lượng sản phẩm trong cart lơn hơn kho");
//				return false;
//			}
//		}
//		return true;
//	}
//
	@Override
	public void buy() {
		List<Heo> heos = new ArrayList<Heo>();
		OrderDTO order = new OrderDTO();
		User user = (User) request.getSession().getAttribute("user");
		order.setId(null);
		order.setCreateDate(new Date());
		order.setStatus(0);
		order.setUser(this.userMapper.convertToDto(user));
		 OrderDTO order1 =  this.orderService.save(order);
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		carts.forEach((t, u) -> {
			Optional<Heo> heo = this.repository.findById(t);
			heo.get().setQuantity(heo.get().getQuantity() - u.getQuantity());
			heos.add(heo.get());
			orderDetail.setHeo(this.heoMapper.convertToDTO(heo.get()));
			orderDetail.setPrice(u.getPrice());
			orderDetail.setQuantity(u.getQuantity());
			orderDetail.setOrder(order1);
			this.orderDetailService.save(orderDetail);

		});
		this.repository.saveAllAndFlush(heos);
		request.getSession().setAttribute("alert", "Thanh toán thành công");
		this.removeProducts();

	}

	@Override
	public boolean checkCartNull() {
		System.out.println(carts.isEmpty());
		if (carts.isEmpty()) {
			request.getSession().setAttribute("alert", "Cart khong co san pham nao");
			return true;
		}
		return false;
	}

	@Override
	public Map<Integer, Cart> getCart() {
		carts.forEach((t, u) -> {
			Optional<Heo> heo = this.repository.findById(u.getHeo().getId());
			u.setPrice(heo.get().getPrice());
		});
		return carts;
	}

	@Override
	public BigDecimal getTotal() {
	BigDecimal total = new BigDecimal("0");
	for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
		Cart val = entry.getValue();
		BigDecimal l = new BigDecimal(val.getQuantity());
		
	   BigDecimal bigDecimal = new BigDecimal((val.getPrice().multiply(l)) +"");
		System.out.println(bigDecimal);
		total =  total.add(bigDecimal);	
	}
	
		return total;
	}

//	@Override
//	public boolean checkQuantity(HeoDTO h) {
//		// TODO Auto-generated method stub
//		return false;
//	}



}
