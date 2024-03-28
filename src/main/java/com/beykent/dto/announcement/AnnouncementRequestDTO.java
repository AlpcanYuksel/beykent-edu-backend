package com.beykent.dto.announcement;

import lombok.Data;

@Data
public class AnnouncementRequestDTO {
	private String title;
	private String text;
	private Boolean banner;
	private String mediaLocation;
}
