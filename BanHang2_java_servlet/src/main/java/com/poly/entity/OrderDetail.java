package com.poly.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private int quantity;
	@Column
	private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private Heo heo;
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Order order;
	
	
}
