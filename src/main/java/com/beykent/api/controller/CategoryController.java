package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.CategoryService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.category.CategoryRequestDTO;
import com.beykent.dto.category.CategoryResponseDTO;
import com.beykent.entities.concretes.Category;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody CategoryRequestDTO request) {
		Category category = modelMapper.forRequest().map(request, Category.class);
		categoryService.create(category);
	}

	@GetMapping("/getAll")
	public List<CategoryResponseDTO> getAll() {
		List<Category> categories = categoryService.getAll();
		List<CategoryResponseDTO> response = categories.stream()
				.map(category -> modelMapper.forResponse().map(category, CategoryResponseDTO.class)).toList();
		return response;
	}

}
