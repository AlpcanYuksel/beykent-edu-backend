package com.beykent.dto.internship;

import java.util.UUID;

import lombok.Data;

@Data
public class InternshipApplicationDTO {
	private UUID internshipId;
	private UUID userId;
	private String explanation;

}
