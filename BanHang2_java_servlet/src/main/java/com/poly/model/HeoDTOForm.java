package com.poly.model;

import java.math.BigDecimal;
import java.util.Date;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HeoDTOForm {

	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	private MultipartFile  image;
	@NotNull(message = "Price khong de trong")
	@Min(value = 0)
	private BigDecimal price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@NotNull(message = "Quantity khong de trong")
	@Min(value = 0)
	private Integer quantity;
	@NotNull
	@Min(value = 0)
	private Integer weight;
	@NotBlank
	private String color;
	private CategoryDTO category;

	

}
