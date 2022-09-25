package com.self.blog.controllers;

import java.util.List;
import java.util.Set;

import com.self.blog.dto.PostPageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.self.blog.dto.PostDto;
import com.self.blog.entities.Post;
import com.self.blog.services.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/{userId}/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable("userId") Long userId, @PathVariable("categoryId") Long categoryId){
		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	};
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Set<PostDto>> getPostByUser(@PathVariable("userId") Long userId){
		Set<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<Set<PostDto>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Set<PostDto>> getPostByCategory(@PathVariable("categoryId") Long categoryId){
		Set<PostDto> posts = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<Set<PostDto>>(posts, HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Long postId){
		return ResponseEntity.ok(this.postService.getPostById(postId));
	}

	@GetMapping()
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> posts = this.postService.getAllPosts();
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@GetMapping("/pageablePosts")
	public ResponseEntity<PostPageableResponse> getPageablePosts(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value="sortDir", defaultValue = "asc", required = false) String sortDir
	){
		PostPageableResponse postResponse = this.postService.getPageablePosts(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostPageableResponse>(postResponse, HttpStatus.OK);
	}
	
}
