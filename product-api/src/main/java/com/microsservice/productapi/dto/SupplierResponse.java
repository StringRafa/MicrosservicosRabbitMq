package com.microsservice.productapi.dto;

import org.springframework.beans.BeanUtils;

import com.microsservice.productapi.model.Supplier;

import lombok.Data;

@Data
public class SupplierResponse {

	private Long id;
	private String name;
	
	public static SupplierResponse of(Supplier supplier) {
		var response = new SupplierResponse();
		BeanUtils.copyProperties(supplier, response);
		return response;
	}
}
