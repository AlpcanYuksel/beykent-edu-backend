package com.beykent.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductRequestDTO {
	private String productName;
	private double unitPrice;
	private String size;
	private int quantity;
	private String mediaLocation;
	private UUID categoryId;
}
