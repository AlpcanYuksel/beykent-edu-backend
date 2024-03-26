package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.ClubRepository;
import com.beykent.dataAccess.UserClubRepository;
import com.beykent.entities.concretes.Club;
import com.beykent.entities.concretes.UserClub;

@Service
public class ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private UserClubRepository userClubRepository;

	public void create(Club club) {
		clubRepository.save(club);
	}

	public List<Club> getAll() {
		return clubRepository.findAll();
	}

	public UserClub clubRegistration(UserClub userClub) {
		return userClubRepository.save(userClub);
	}

}
