package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.UserClub;

public interface UserClubRepository extends JpaRepository<UserClub, UUID> {

}
