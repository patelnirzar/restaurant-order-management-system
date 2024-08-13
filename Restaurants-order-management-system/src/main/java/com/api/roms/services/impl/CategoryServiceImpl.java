package com.api.roms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.roms.entities.Category;
import com.api.roms.repositories.CategoryRepo;
import com.api.roms.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	// Create Category
	@Override
	public Category createCategory(Category category) {
		
		Category savedCategory= this.categoryRepo.save(category);
		return savedCategory;
	}

}
