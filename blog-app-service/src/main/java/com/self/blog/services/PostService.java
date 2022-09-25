package com.self.blog.services;

import java.util.List;
import java.util.Set;

import com.self.blog.dto.PostDto;
import com.self.blog.dto.PostPageableResponse;
import com.self.blog.entities.Post;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Long userId, Long categoryId);
	
	Post updatePost(PostDto postDto, Long id);
	
	Void deletePost(Long id);

	List<PostDto> getAllPosts();

	PostPageableResponse getPageablePosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	PostDto getPostById(Long id);
	
	Set<PostDto> getPostByCategory(Long categoryId);
	
	Set<PostDto> getPostByUser(Long userId);
	
	Set<Post> searchPost(String searchPost);

}
