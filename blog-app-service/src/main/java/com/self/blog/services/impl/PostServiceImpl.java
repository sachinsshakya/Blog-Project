/**
 * 
 */
package com.self.blog.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.self.blog.dto.PostPageableResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.self.blog.dto.CategoryDto;
import com.self.blog.dto.PostDto;
import com.self.blog.dto.UserDto;
import com.self.blog.entities.Category;
import com.self.blog.entities.Post;
import com.self.blog.entities.User;
import com.self.blog.exceptions.ResourceNotFoundException;
import com.self.blog.repositories.CategoryRepository;
import com.self.blog.repositories.PostRepository;
import com.self.blog.repositories.UserRepository;
import com.self.blog.services.CategoryService;
import com.self.blog.services.PostService;
import com.self.blog.services.UserService;


/**
 * @author SACHIN SINGH	
 *
 */
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Override
	public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
		 
		User user = this.modelMapper.map(userService.getById(userId), User.class);
		Category category = this.modelMapper.map(categoryService.getById(categoryId), Category.class);
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setCreatedAt(LocalDateTime.now());
		post.setUser(user);
		post.setCategory(category);
		post.setImageUrl("default.png");
		Post savedPost = postRepository.save(post);
		return modelMapper.map(savedPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deletePost(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = this.postRepository.findAll();
		return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostPageableResponse getPageablePosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post> pagePost = this.postRepository.findAll(pageable);
		List<Post> posts = pagePost.getContent();
		List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostPageableResponse postPageableResponse = new PostPageableResponse();
		postPageableResponse.setPosts(postDtos);
		postPageableResponse.setPageNumber(pagePost.getNumber());
		postPageableResponse.setPageSize(pagePost.getSize());
		postPageableResponse.setTotalPosts(pagePost.getTotalElements());
		postPageableResponse.setTotalPages(pagePost.getTotalPages());
		postPageableResponse.setLastPage(pagePost.isLast());
		return postPageableResponse;
	}

	@Override
	public PostDto getPostById(Long id) {
		Post post = this.postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public Set<PostDto> getPostByCategory(Long categoryId) {		// TODO Auto-generated method stub
		CategoryDto categoryDto = categoryService.getById(categoryId);
		Set<Post> posts = postRepository.findByCategory(modelMapper.map(categoryDto, Category.class));
		return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toSet());
	}

	@Override
	public Set<PostDto> getPostByUser(Long userId) {
		User user =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		Set<Post> posts = postRepository.findByUser(user);
		return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toSet());
	}

	@Override
	public Set<Post> searchPost(String searchPost) {
		// TODO Auto-generated method stub
		return null;
	}

}
