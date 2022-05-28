package com.microsservice.productapi.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsservice.productapi.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private Long id;
	
	private String name;
	
	private SupplierResponse supplier;

	private CategoryResponse category;
	
	private Double price;
	
	@JsonProperty("quantity_available")
	private Integer quantityAvailable;
	
	@JsonProperty("created_at")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	
	public static ProductResponse of(Product product) {
		return ProductResponse
				.builder()
				.id(product.getId())
				.name(product.getName())
				.supplier(SupplierResponse.of(product.getSupplier()))
				.category(CategoryResponse.of(product.getCategory()))
				.price(product.getPrice())
				.quantityAvailable(product.getQuantityAvailable())
				.createdAt(product.getCreatedAt())
				.build();
	}
}
