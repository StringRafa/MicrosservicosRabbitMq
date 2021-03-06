package com.microsservice.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservice.productapi.dto.ProductRequest;
import com.microsservice.productapi.dto.ProductResponse;
import com.microsservice.productapi.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ProductResponse save(@RequestBody ProductRequest request) {
		return productService.save(request);
	}
}
