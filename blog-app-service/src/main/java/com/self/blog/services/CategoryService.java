package com.self.blog.services;

import java.util.List;

import com.self.blog.dto.CategoryDto;

public interface CategoryService {
	
	//create 
	CategoryDto create(CategoryDto categoryDto);
	
	//update
	CategoryDto update(CategoryDto categoryDto);
	
	//delete 
	void delete(Long id);
	
	//get 
	CategoryDto getById(Long id);
	
	//getAll
	List<CategoryDto> getAll();
}
