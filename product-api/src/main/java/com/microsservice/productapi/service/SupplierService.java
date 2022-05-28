package com.microsservice.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservice.productapi.config.exception.ValidationException;
import com.microsservice.productapi.dto.SupplierRequest;
import com.microsservice.productapi.dto.SupplierResponse;
import com.microsservice.productapi.model.Supplier;
import com.microsservice.productapi.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier findById(Long id) {
		return supplierRepository
				.findById(id)
				.orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
	}
	
	public SupplierResponse save(SupplierRequest request) {
		validateSupplierNameInformed(request);
		var category = supplierRepository.save(Supplier.of(request));
		return SupplierResponse.of(category);
	}
	
	private void validateSupplierNameInformed(SupplierRequest request) {
		if (isEmpty(request.getName())) {
			throw new ValidationException("The supplier name was not informed.");
		}
	}
}
