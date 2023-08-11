package com.poly.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.poly.entity.Heo;
import com.poly.model.Cart;
import com.poly.model.HeoDTO;
public interface IWishlist {

     List<HeoDTO> getCart();
	
	// them san pham vao gio hang
	void addToWishlist(int productId);
	
	// bo 1 san pham trong gio
	void removeProduct(int productId);
//	
	// bo tat ca san pham trong gio
	void removeProducts();

	
}
