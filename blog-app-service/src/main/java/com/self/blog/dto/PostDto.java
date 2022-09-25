package com.self.blog.dto;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private Long postId;
	private String postTitle;
	private String postContent;
	private String imageUrl;
	private LocalDateTime createdAt;
	private CategoryDto category;
	private UserDto user;
	
}
