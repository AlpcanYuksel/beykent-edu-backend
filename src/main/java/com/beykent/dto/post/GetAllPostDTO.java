package com.beykent.dto.post;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.beykent.dto.comment.CommentResponseDTO;

import lombok.Data;

@Data
public class GetAllPostDTO {
	private UUID id;
	private String writtenText;
	private String mediaLocation;
	private Date createdDatetime;
	private List<PostLikeResponseDTO> postLike;
	private List<CommentResponseDTO> comments;

}
