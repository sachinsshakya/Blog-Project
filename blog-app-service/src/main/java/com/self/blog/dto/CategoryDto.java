package com.self.blog.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Long categoryId;
	
	@NotEmpty
	@Size(min = 3, max= 20)
	private String categoryName;
	
	@NotEmpty
	@Size(min = 10, max = 200)
	private String categoryDescription;

}
