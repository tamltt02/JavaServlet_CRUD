package com.poly.model;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeoDTO {

	private Integer id;

	private String name;
	private String  image;

	private BigDecimal price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	private int quantity;

	private int weight;

	private String color;
	private CategoryDTO category;

}
