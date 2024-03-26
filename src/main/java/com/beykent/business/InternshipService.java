package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.InternshipApplicationRepository;
import com.beykent.dataAccess.InternshipRepository;
import com.beykent.entities.concretes.Internship;
import com.beykent.entities.concretes.InternshipApplication;

@Service
public class InternshipService {

	@Autowired
	private InternshipRepository internshipRepository;
	@Autowired
	private InternshipApplicationRepository applicationRepository;

	public Internship create(Internship internship) {
		return internshipRepository.save(internship);
	}

	public InternshipApplication applyInternship(InternshipApplication application) {
		return applicationRepository.save(application);
	}
	
	public List<Internship> getAll(){
		return internshipRepository.findAll();
	}

}
