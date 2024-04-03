package com.beykent.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.CommentService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.comment.CommentLikeRequestDTO;
import com.beykent.dto.comment.CommentRequestDTO;
import com.beykent.dto.comment.CommentResponseDTO;
import com.beykent.entities.concretes.Comment;
import com.beykent.entities.concretes.CommentLike;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody CommentRequestDTO request) {
		Comment comment = modelMapper.forRequest().map(request, Comment.class);
		commentService.create(comment);
	}

	@PostMapping("/commentLike")
	public void commentLike(CommentLikeRequestDTO request) {
		CommentLike commentLike = modelMapper.forRequest().map(request, CommentLike.class);
		commentService.commentLike(commentLike);

	}

	@GetMapping("/getAllCommentWithPostId")
	private List<CommentResponseDTO> getAllCommentWithPostId(@RequestParam UUID postId) {
		List<Comment> comments = commentService.getAllCommentWithPostId(postId);
		List<CommentResponseDTO> response = comments.stream()
				.map(comment -> modelMapper.forResponse().map(comment, CommentResponseDTO.class)).toList();
		return response;
	}

	@DeleteMapping("/deleteComment")
	public void delete(UUID commentId) {
		commentService.delete(commentId);
	}

}
