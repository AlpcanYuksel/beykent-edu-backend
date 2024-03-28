package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.AnnouncementRepository;
import com.beykent.entities.concretes.Announcement;

@Service
public class AnnouncementService {

	@Autowired
	private AnnouncementRepository announcementRepository;

	public void create(Announcement announcement) {
		announcementRepository.save(announcement);
	}

	public List<Announcement> getAll() {
		return announcementRepository.findAll();
	}

}
