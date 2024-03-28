package com.beykent.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beykent.business.ProductService;
import com.beykent.core.utilities.mappers.ModelMapperService;
import com.beykent.dto.product.ProductRequestDTO;
import com.beykent.dto.product.ProductResponseDTO;
import com.beykent.entities.concretes.Product;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapperService modelMapper;

	@PostMapping("/create")
	public void create(@RequestBody ProductRequestDTO request) {
		Product product = modelMapper.forRequest().map(request, Product.class);
		productService.create(product);
	}

	@GetMapping("/getAll")
	public List<ProductResponseDTO> getAll() {
		List<Product> products = productService.getAll();
		List<ProductResponseDTO> response = products.stream()
				.map(product -> modelMapper.forResponse().map(product, ProductResponseDTO.class)).toList();
		return response;
	}

}
