package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.InternshipApplication;

public interface InternshipApplicationRepository extends JpaRepository<InternshipApplication, UUID> {

}
