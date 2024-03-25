package com.beykent.dto.user;

import java.util.List;

import com.beykent.dto.post.GetAllPostDTO;

import lombok.Data;

@Data
public class GetUserPostsDTO {

	private List<GetAllPostDTO> posts;

}
