package com.microsservice.productapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.microsservice.productapi.dto.ProductRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "NAME",  nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "FK_SUPPLIER", nullable = false)
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "FK_CATEGORY", nullable = false)
	private Category category;
	
	@Column(name = "QUANTITY_AVAILABLE",  nullable = false)
	private Integer quantityAvailable;
	
	@Column(name = "PRICE", nullable = false)
	private Double price;
	
	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}
	
	public static Product of(ProductRequest request, Supplier supplier, Category category) {
		return Product
				.builder()
				.name(request.getName())
				.supplier(supplier)
				.category(category)
				.quantityAvailable(request.getQuantityAvailable())
				.price(request.getPrice())
				.build();
	}
}
