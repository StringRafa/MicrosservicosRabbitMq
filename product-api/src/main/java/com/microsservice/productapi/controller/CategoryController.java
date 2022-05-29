package com.microsservice.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservice.productapi.dto.CategoryRequest;
import com.microsservice.productapi.dto.CategoryResponse;
import com.microsservice.productapi.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public CategoryResponse save(@RequestBody CategoryRequest request) {
		return categoryService.save(request);
	}
	
	@GetMapping
	public List<CategoryResponse> findAll(){
		return categoryService.findAll();
	}
	
	@GetMapping("{id}")
	public CategoryResponse findById(@PathVariable Long id){
		return categoryService.findByIdResponse(id);
	}
	
	@GetMapping("/description/{description}")
	public List<CategoryResponse> findByDescription(@PathVariable String description){
		return categoryService.findByDescription(description);
	}
}
