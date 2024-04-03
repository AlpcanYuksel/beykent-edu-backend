package com.beykent.dto.comment;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class CommentResponseDTO {
	private UUID id;
	private UUID userId;
	private String text;
	private List<CommentLikeResponseDTO> commentLikes;
}
