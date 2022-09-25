package com.self.blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.blog.dto.UserDto;
import com.self.blog.entities.User;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.repositories.UserRepository;
import com.self.blog.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	@Override
	public UserDto create(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		User savedUser = userRepository.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto update(UserDto userDto) {
		Long id = userDto.getId();
		User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id)); 
		assert user != null;
		User userToSave = this.dtoToUser(userDto);
		userToSave.setUpdatedAt(LocalDateTime.now());
		User SavedUser = this.userRepository.save(userToSave);
		return this.UserToDto(SavedUser);
	}

	@Override
	public UserDto getById(Long Id) {
		User user =  userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", Id));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAll() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> usersDto = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return usersDto;
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto UserToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public void delete(Long id) {
		User user=this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id", id));
		this.userRepository.delete(user);
	}

}
