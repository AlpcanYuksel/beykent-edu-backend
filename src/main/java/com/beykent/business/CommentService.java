package com.beykent.business;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.CommentLikeRepository;
import com.beykent.dataAccess.CommentRepository;
import com.beykent.entities.concretes.Comment;
import com.beykent.entities.concretes.CommentLike;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CommentLikeRepository commentLikeRepository;

	public void create(Comment comment) {
		commentRepository.save(comment);
	}

	public List<Comment> getAllCommentWithPostId(UUID postId) {
		return commentRepository.findAllByPostId(postId);
	}

	public void delete(UUID commentId) {
		Comment comment = commentRepository.findById(commentId).orElseThrow();
		commentRepository.delete(comment);
	}

	public void commentLike(CommentLike commentLike) {
		commentLikeRepository.save(commentLike);
	}

}
