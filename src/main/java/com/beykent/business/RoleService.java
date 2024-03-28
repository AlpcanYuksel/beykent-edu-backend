package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.RoleRepository;
import com.beykent.entities.concretes.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public void create(Role role) {
		roleRepository.save(role);
	}

	public List<Role> getAll() {
		return roleRepository.findAll();
	}

}
