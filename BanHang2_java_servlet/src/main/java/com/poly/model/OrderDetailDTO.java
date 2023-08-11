package com.poly.model;
import java.math.BigDecimal;

import lombok.Data;
@Data
public class OrderDetailDTO {
	private Integer id;

	private int quantity;

	private BigDecimal price;

	private HeoDTO heo;

	private OrderDTO order;
}
