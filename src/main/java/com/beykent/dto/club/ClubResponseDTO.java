package com.beykent.dto.club;

import java.util.UUID;

import lombok.Data;

@Data
public class ClubResponseDTO {

	private UUID id;
	private String name;
	private String mediaLocation;

}
