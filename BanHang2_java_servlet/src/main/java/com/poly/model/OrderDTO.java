package com.poly.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer id;

	private int status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	private UserDTO user;
	
	private List<OrderDetailDTO> orderDetails;
	private BigDecimal total;
}
