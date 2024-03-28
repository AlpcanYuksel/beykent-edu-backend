package com.beykent.dto.role;

import java.util.List;
import java.util.UUID;

import com.beykent.dto.user.GetUserResponseDTO;

import lombok.Data;

@Data
public class RoleResponseDTO {
	private UUID id;
	private String name;
	private List<GetUserResponseDTO> user;

}
