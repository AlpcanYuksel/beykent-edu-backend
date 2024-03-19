package com.beykent.dto.follow;

import com.beykent.entities.concretes.User;

import lombok.Data;

@Data
public class FollowRequestDTO {
	private User followers;
	private User followed;
}
