package com.beykent.dto.comment;

import java.util.UUID;

import lombok.Data;

@Data
public class CommentLikeRequestDTO {
	private UUID commentId;
	private UUID userId;

}
