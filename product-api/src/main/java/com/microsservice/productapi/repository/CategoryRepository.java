package com.microsservice.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microsservice.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
