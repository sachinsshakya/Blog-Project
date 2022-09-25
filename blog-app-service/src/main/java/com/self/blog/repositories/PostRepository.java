package com.self.blog.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entities.Category;
import com.self.blog.entities.Post;
import com.self.blog.entities.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	Set<Post> findByUser(User user);
	
	Set<Post> findByCategory(Category category); 
	
	Set<Post> findByUserId(Long userId);
}
