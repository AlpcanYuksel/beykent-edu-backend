package com.beykent.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.UserService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.follow.FollowerResponseDTO;
import com.beykent.dto.user.GetAllUserResponseDTO;
import com.beykent.dto.user.UserRequestDTO;
import com.beykent.entities.concretes.User;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	// test

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/createUser")
	public void create(@RequestBody UserRequestDTO userRequestDTO) {
		User user = modelMapper.forResponse().map(userRequestDTO, User.class);
		userService.create(user);
	}

	@PostMapping("/followUser")
	public boolean followUser(@RequestBody UUID followerId, @RequestBody UUID followingId) {
		return userService.followUser(followerId, followingId);
	}

	@GetMapping("getAllUser")
	public List<GetAllUserResponseDTO> getAll() {

		List<User> user = userService.getAll();

		return user.stream().map(users -> modelMapper.forResponse().map(users, GetAllUserResponseDTO.class)).toList();
	}

	@GetMapping("getUserFollowings")
	public List<FollowerResponseDTO> findFollowings(@RequestBody UUID userId) {
		List<User> user = userService.findFollowings(userId);
		return user.stream().map(users -> modelMapper.forResponse().map(users, FollowerResponseDTO.class)).toList();
	}

//	@GetMapping("getUserFollowers")
//	public List<FollowerResponseDTO> findFollowings(@ResponseBody UUID userId) {
//		List<User> user = userService.findFollowings(userId);
//		return user.stream().map(users -> modelMapper.forResponse().map(users, FollowerResponseDTO.class)).toList();
//	}

}
