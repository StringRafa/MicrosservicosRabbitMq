package com.microsservice.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microsservice.productapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
