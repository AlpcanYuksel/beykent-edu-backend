package com.beykent.dto.category;

import java.util.List;
import java.util.UUID;

import com.beykent.dto.product.ProductResponseDTO;

import lombok.Data;

@Data
public class CategoryResponseDTO {

	private UUID id;

	private String categoryName;

	private List<ProductResponseDTO> products;

}
