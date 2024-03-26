package com.beykent.dto.club;

import java.util.UUID;

import lombok.Data;

@Data
public class ClubRegistrationDTO {
	private UUID userId;
	private UUID clubId;

}
