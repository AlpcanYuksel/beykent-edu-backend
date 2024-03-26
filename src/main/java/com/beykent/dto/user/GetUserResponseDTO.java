package com.beykent.dto.user;

import java.util.List;
import java.util.UUID;

import com.beykent.dto.club.ClubResponseDTO;
import com.beykent.dto.follow.FollowerResponseDTO;
import com.beykent.dto.internship.InternshipResponseDTO;
import com.beykent.dto.post.GetAllPostDTO;

import lombok.Data;

@Data
public class GetUserResponseDTO {

	private UUID id;
	private String fullName;
	private String studentNo;
	private String profilePhoto;
	private String personalInformation;

	private List<GetAllPostDTO> posts;
	private List<FollowerResponseDTO> followers;
	private List<FollowerResponseDTO> followings;
	private List<ClubResponseDTO> userClubs;
	private List<InternshipResponseDTO> internshipApplications;

}
