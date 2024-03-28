package com.beykent.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beykent.dataAccess.ProductRepository;
import com.beykent.entities.concretes.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void create(Product product) {
		productRepository.save(product);
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
