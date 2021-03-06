package com.microsservice.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservice.productapi.config.exception.ValidationException;
import com.microsservice.productapi.dto.ProductRequest;
import com.microsservice.productapi.dto.ProductResponse;
import com.microsservice.productapi.model.Product;
import com.microsservice.productapi.repository.ProductRepository;

@Service
public class ProductService {
	
	private static final Integer ZERO = 0;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	public ProductResponse save(ProductRequest request) {
		validateProductDataInformed(request);
		validateCategoryAndSupplierInformed(request);
		var category = categoryService.findById(request.getCategoryId());
		var supplier = supplierService.findById(request.getSupplierId());
		var product = productRepository.save(Product.of(request, supplier, category));
		return ProductResponse.of(product);
	}
	
	private void validateProductDataInformed(ProductRequest request) {
		if (isEmpty(request.getName())) {
			throw new ValidationException("The product's name was not informed.");
		}
		if (isEmpty(request.getQuantityAvailable())) {
			throw new ValidationException("The product's quantity was not informed.");
		}
		if (request.getQuantityAvailable() <= ZERO) {
			throw new ValidationException("The quantity should not be less or equal to zero.");
		}
	}
	
	private void validateCategoryAndSupplierInformed(ProductRequest request) {
		if (isEmpty(request.getCategoryId())) {
			throw new ValidationException("The category ID name was not informed.");
		}
		if (isEmpty(request.getSupplierId())) {
			throw new ValidationException("The supplier ID name was not informed.");
		}
	}
}
