package com.poly.model;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {
	
	private Integer id;
	@NotBlank
	private String name;
	
    private String note;

}
