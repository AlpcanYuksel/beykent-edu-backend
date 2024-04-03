package com.beykent.dto.comment;

import java.util.UUID;

import lombok.Data;

@Data
public class CommentRequestDTO {
	private String text;
	private UUID userId;
	private UUID postId;

}
