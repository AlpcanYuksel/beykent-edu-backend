package com.beykent.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.PostService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.post.CreatePostDTO;
import com.beykent.dto.post.PostLikeRequestDTO;
import com.beykent.entities.concretes.Post;
import com.beykent.entities.concretes.PostLike;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody CreatePostDTO request) {
		Post post = modelMapper.forRequest().map(request, Post.class);
		postService.create(post);
	}

	@PostMapping("/postLike")
	public void postLike(@RequestBody PostLikeRequestDTO request) {
		PostLike postLike = modelMapper.forRequest().map(request, PostLike.class);
		postService.postLike(postLike);
	}

}
