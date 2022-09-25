package com.self.blog.services;

import java.util.List;

import com.self.blog.dto.UserDto;
import com.self.blog.entities.User;

public interface UserService {
	
	//create
	UserDto create(UserDto user);
	
	//update
	UserDto update(UserDto user);
	
	//get
	UserDto getById(Long Id);
	
	//getAll
	List<UserDto> getAll();
	
	//delete
	void delete(Long id);

}
