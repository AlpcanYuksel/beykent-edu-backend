package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, UUID> {

}
