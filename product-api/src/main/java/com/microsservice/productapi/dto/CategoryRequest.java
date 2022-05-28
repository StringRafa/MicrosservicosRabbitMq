package com.microsservice.productapi.dto;

import org.springframework.beans.BeanUtils;

import com.microsservice.productapi.model.Category;

import lombok.Data;

@Data
public class CategoryRequest {

	private Long id;
	private String description;
	
	public static CategoryRequest of(Category category) {
		var response = new CategoryRequest();
		BeanUtils.copyProperties(category, response);
		return response;
	}
}
