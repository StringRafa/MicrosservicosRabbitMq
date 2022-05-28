package com.microsservice.productapi.dto;

import org.springframework.beans.BeanUtils;

import com.microsservice.productapi.model.Category;

import lombok.Data;

@Data
public class CategoryResponse {

	private Long id;
	private String description;
	
	public static CategoryResponse of(Category category) {
		var response = new CategoryResponse();
		BeanUtils.copyProperties(category, response);
		return response;
	}
}
