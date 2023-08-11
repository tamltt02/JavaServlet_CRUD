package com.poly.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;
@Data
public class Cart {

	// Key: ma san pham, Value: so luong san pham
	private  HeoDTO heo;
	private BigDecimal price;
	private int quantity;


	
	
}
