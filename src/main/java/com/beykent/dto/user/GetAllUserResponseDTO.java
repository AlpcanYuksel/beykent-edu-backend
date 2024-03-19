package com.beykent.dto.user;

import java.util.UUID;

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

}
