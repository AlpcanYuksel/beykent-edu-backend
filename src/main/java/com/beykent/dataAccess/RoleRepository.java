package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

}
