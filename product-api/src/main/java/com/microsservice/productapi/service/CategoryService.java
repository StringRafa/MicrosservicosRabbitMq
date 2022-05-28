package com.microsservice.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservice.productapi.config.exception.ValidationException;
import com.microsservice.productapi.dto.CategoryRequest;
import com.microsservice.productapi.dto.CategoryResponse;
import com.microsservice.productapi.model.Category;
import com.microsservice.productapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findById(Long id) {
		return categoryRepository
				.findById(id)
				.orElseThrow(() -> new ValidationException("There's no category for the given ID."));
	}
	
	public CategoryResponse save(CategoryRequest request) {
		validateCategoryNameInformed(request);
		var category = categoryRepository.save(Category.of(request));
		return CategoryResponse.of(category);
	}
	
	private void validateCategoryNameInformed(CategoryRequest request) {
		if (isEmpty(request.getDescription())) {
			throw new ValidationException("The category description was not informed.");
		}
	}
}
