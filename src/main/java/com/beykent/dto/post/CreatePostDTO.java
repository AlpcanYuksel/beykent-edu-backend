package com.beykent.dto.post;

import java.util.UUID;

import lombok.Data;

@Data
public class CreatePostDTO {

	private UUID userId;
	private String writtenText;
	private String mediaLocation;

}
