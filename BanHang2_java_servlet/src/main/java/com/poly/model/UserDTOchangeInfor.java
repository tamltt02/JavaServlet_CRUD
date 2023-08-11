package com.poly.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDTOchangeInfor {

	private Integer id;
	@NotBlank
	private String username;
	@NotBlank
	@Length(min = 9 ,max = 11)
	private String sdt;
	@NotBlank
	private String address;
	@NotBlank
	@Email
	private String email;
}
