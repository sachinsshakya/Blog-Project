package com.self.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 3, message = "Name should have atleast 3 characters")
	private String name;
	
	@Email(message = "Email address is not valid!!")
	private String email;
	
	@NotEmpty
	@Size(min=5, max=16, message="Password must be in between 5 to 14 Characters")
	private String password;
	
	@NotEmpty
	private String about;

}
