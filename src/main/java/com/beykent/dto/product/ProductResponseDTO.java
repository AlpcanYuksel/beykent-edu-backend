package com.beykent.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductResponseDTO {
	private UUID id;
	private String productName;
	private double unitPrice;
	private String size;
	private int quantity;
	private String mediaLocation;
	private String categoryName;
}
