package com.beykent.dto.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
	private String studentNo;
	private String password;
	private String fullName;
	private UUID roleId;
}
