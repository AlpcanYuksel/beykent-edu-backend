package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
