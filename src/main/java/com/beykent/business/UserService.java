package com.beykent.business;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.UserRepository;
import com.beykent.entities.concretes.User;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public boolean followUser(UUID followerId, UUID followingId) {
		if (followerId == followingId) {
			// Kullanıcı kendini takip edemez
			return false;
		}

		User follower = userRepository.findById(followerId)
				.orElseThrow(() -> new RuntimeException("Takip eden kullanıcı bulunamadı."));
		User following = userRepository.findById(followingId)
				.orElseThrow(() -> new RuntimeException("Takip edilen kullanıcı bulunamadı."));

		// Zaten takip ediliyor mu kontrolü
		if (follower.getFollowings().contains(following)) {
			return false; // Zaten takip ediliyorsa işlem yapma
		}

		follower.getFollowings().add(following);
		following.getFollowers().add(follower);

		userRepository.save(follower);
		userRepository.save(following);
		return true;
	}

	public void create(User user) {
		userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getUser(UUID id) {
		return userRepository.findById(id).orElseThrow();
	}

	public User updateUserProfile(User user) {
		User updateUser = userRepository.findById(user.getId()).orElseThrow();
		user.setPassword(updateUser.getPassword());
		user.setStudentNo(updateUser.getStudentNo());
		return userRepository.save(user);

	}
//
//	public List<User> findFollowings(UUID userId) {
//		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//		return user.getFollowings();
//	}

//	public List<Post> findUserPosts(UUID userId) {
//		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//		return user.getPosts();
//	}

//	public void delete(UUID id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void update(UUID id, User entity) {
//		// TODO Auto-generated method stub
//
//	}

}
