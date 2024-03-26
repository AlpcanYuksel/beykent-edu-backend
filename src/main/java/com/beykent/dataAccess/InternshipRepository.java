package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.Internship;

public interface InternshipRepository extends JpaRepository<Internship, UUID> {

}
