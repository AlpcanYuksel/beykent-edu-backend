package com.beykent.dto.internship;

import java.util.UUID;

import lombok.Data;

@Data
public class InternshipResponseDTO {
	private UUID id;
	private UUID internshipId;
	private String name;
	private String mediaLocation;
	private String explanation;

}
