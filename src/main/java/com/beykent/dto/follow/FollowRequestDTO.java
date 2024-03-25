package com.beykent.dto.follow;

import java.util.UUID;

import lombok.Data;

@Data
public class FollowRequestDTO {
	private UUID followerId;
	private UUID followingId;
}
