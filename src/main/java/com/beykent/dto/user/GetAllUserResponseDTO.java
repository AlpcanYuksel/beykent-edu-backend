package com.beykent.dto.user;

import java.util.List;
import java.util.UUID;

import com.beykent.dto.follow.FollowerResponseDTO;
import com.beykent.dto.post.GetAllPostDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponseDTO {

	private UUID id;
	private String fullName;
	private String studentNo;
	private List<GetAllPostDTO> posts;
	private List<FollowerResponseDTO> followers;
	private List<FollowerResponseDTO> followings;

}