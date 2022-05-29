package com.microsservice.productapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.microsservice.productapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Transactional(readOnly = true)
	List<Category> findByDescriptionIgnoreCaseContaining(String description);
	
}
