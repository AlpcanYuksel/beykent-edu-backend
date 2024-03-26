package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.ClubService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.club.ClubRegistrationDTO;
import com.beykent.dto.club.ClubRequestDTO;
import com.beykent.dto.club.ClubResponseDTO;
import com.beykent.entities.concretes.Club;
import com.beykent.entities.concretes.UserClub;

@RestController
@RequestMapping("api/v1/club")
public class ClubController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody ClubRequestDTO request) {
		Club club = modelMapper.forRequest().map(request, Club.class);
		clubService.create(club);
	}

	@PostMapping("/clubRegistration")
	public UserClub clubRegistration(@RequestBody ClubRegistrationDTO request) {
		UserClub userClub = modelMapper.forRequest().map(request, UserClub.class);
		return clubService.clubRegistration(userClub);
	}

	@GetMapping("/getAll")
	public List<ClubResponseDTO> getAll() {
		List<Club> clubs = clubService.getAll();
		List<ClubResponseDTO> response = clubs.stream()
				.map(club -> modelMapper.forResponse().map(club, ClubResponseDTO.class)).toList();
		return response;
	}

}
