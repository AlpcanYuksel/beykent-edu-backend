package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.InternshipService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.internship.InternshipApplicationDTO;
import com.beykent.dto.internship.InternshipRequestDTO;
import com.beykent.dto.internship.InternshipResponseDTO;
import com.beykent.entities.concretes.Internship;
import com.beykent.entities.concretes.InternshipApplication;

@RestController
@RequestMapping("api/v1/ınternShip")
public class InternshipController {

	@Autowired
	private InternshipService internshipService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody InternshipRequestDTO request) {
		Internship internship = modelMapper.forRequest().map(request, Internship.class);
		internshipService.create(internship);
	}

	@PostMapping("/apply")
	public void applyInternship(@RequestBody InternshipApplicationDTO request) {
		InternshipApplication application = modelMapper.forRequest().map(request, InternshipApplication.class);
		internshipService.applyInternship(application);
	}

	@GetMapping("/getAll")
	public List<InternshipResponseDTO> getAll() {
		List<Internship> internships = internshipService.getAll();
		return internships.stream()
				.map(internship -> modelMapper.forResponse().map(internship, InternshipResponseDTO.class)).toList();

	}
}
