package com.beykent.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.PostLikeRepository;
import com.beykent.dataAccess.PostRepository;
import com.beykent.entities.concretes.Post;
import com.beykent.entities.concretes.PostLike;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostLikeRepository postLikeRepository;

	public void create(Post post) {
		postRepository.save(post);
	}

	public void postLike(PostLike postLike) {
		postLikeRepository.save(postLike);
	}

}
