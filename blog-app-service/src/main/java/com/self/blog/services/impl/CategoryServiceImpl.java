package com.self.blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.blog.dto.CategoryDto;
import com.self.blog.entities.Category;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.repositories.CategoryRepository;
import com.self.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto create(CategoryDto categoryDto) {
		
		Category category = this.dtoToCategory(categoryDto);
		category.setCreatedAt(LocalDateTime.now());
		category.setUpdatedAt(LocalDateTime.now());
		Category savedCategory = this.categoryRepository.save(category);
		return this.categoryToDto(category);
	}

	@Override
	public CategoryDto update(CategoryDto categoryDto) {
		Category category = this.categoryRepository.findById(categoryDto.getCategoryId()).orElseThrow(() ->new ResourceNotFoundException("Category", "Id", categoryDto.getCategoryId()));
		category.setDescription(categoryDto.getCategoryDescription());
		category.setName(categoryDto.getCategoryName());
		category.setUpdatedAt(LocalDateTime.now());
		return this.categoryToDto(this.categoryRepository.save(category));
	}

	@Override
	public void delete(Long id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Category", "Id", id));
		this.categoryRepository.delete(category);
	}

	@Override
	public CategoryDto getById(Long id) {
		Category category = this.categoryRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Category", "Id", id));
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAll() {
		List<Category> categories = this.categoryRepository.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(cat -> this.categoryToDto(cat)).collect(Collectors.toList());
		return categoryDtos;
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		return category;
	}
	
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
