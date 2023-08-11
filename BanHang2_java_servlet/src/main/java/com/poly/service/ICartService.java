package com.poly.service;
import java.math.BigDecimal;
import java.util.Map;
import com.poly.model.Cart;
public interface ICartService {

	Map<Integer, Cart> getCart();
	
	// them san pham vao gio hang
	void addToCart(int productId, int quantity);
	
	// thay doi so luong san pham trong gio
	void changeProductQuantity(int productId, int quantity);
	
	// bo 1 san pham trong gio
	void removeProduct(int productId);
//	
	// bo tat ca san pham trong gio
	void removeProducts();
//
//	boolean checkQuantity(HeoDTO h);
//	//Thanh Toán
	boolean checkCartNull();
	void buy();
	BigDecimal getTotal();
	
}
