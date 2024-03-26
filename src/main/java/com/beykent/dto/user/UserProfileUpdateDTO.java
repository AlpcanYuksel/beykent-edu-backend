package com.beykent.dto.user;

import java.util.UUID;

import lombok.Data;

@Data
public class UserProfileUpdateDTO {
	private UUID id;
	private String fullName;
	private String profilePhoto;
	private String personalInformation;

}
