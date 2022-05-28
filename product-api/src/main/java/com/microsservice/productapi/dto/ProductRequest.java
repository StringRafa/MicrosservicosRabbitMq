package com.microsservice.productapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductRequest {

	private String name;
	
	private Long supplierId;

	private Long categoryId;
	
	private Double price;
	
	@JsonProperty("quantity_available")
	private Integer quantityAvailable;
}
