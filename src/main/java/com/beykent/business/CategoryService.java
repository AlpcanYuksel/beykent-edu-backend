package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.CategoryRepository;
import com.beykent.entities.concretes.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void create(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

}
