package com.microsservice.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservice.productapi.dto.SupplierRequest;
import com.microsservice.productapi.dto.SupplierResponse;
import com.microsservice.productapi.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public SupplierResponse save(@RequestBody SupplierRequest request) {
		return supplierService.save(request);
	}
}
