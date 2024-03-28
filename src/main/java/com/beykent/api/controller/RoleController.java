package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.RoleService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.role.RoleRequestDTO;
import com.beykent.dto.role.RoleResponseDTO;
import com.beykent.entities.concretes.Role;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(RoleRequestDTO request) {
		Role role = modelMapper.forRequest().map(request, Role.class);
		roleService.create(role);
	}

	@GetMapping("/getAll")
	public List<RoleResponseDTO> getAll() {
		List<Role> roles = roleService.getAll();
		List<RoleResponseDTO> response = roles.stream()
				.map(role -> modelMapper.forResponse().map(role, RoleResponseDTO.class)).toList();
		return response;
	}

}
