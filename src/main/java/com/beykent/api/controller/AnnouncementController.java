package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.AnnouncementService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.announcement.AnnouncementRequestDTO;
import com.beykent.dto.announcement.AnnouncementResponseDTO;
import com.beykent.entities.concretes.Announcement;

@RestController
@RequestMapping("api/v1/announcement")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody AnnouncementRequestDTO request) {
		Announcement announcement = modelMapper.forRequest().map(request, Announcement.class);
		announcementService.create(announcement);
	}

	@GetMapping("/getAll")
	public List<AnnouncementResponseDTO> getAll() {
		List<Announcement> announcements = announcementService.getAll();
		List<AnnouncementResponseDTO> response = announcements.stream()
				.map(announcement -> modelMapper.forResponse().map(announcement, AnnouncementResponseDTO.class))
				.toList();
		return response;
	}

}
