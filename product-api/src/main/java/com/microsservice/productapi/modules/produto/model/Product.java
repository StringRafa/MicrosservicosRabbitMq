package com.microsservice.productapi.modules.produto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
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
}