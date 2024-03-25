package com.beykent.dto.post;

import java.util.UUID;

import lombok.Data;

@Data
public class PostLikeRequestDTO {

	private UUID userId;
	private UUID postId;

}
