package com.api.roms.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.roms.entities.Category;
import com.api.roms.services.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
public class CategoriesAdminController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	// Create Category
	@PostMapping("/category/create")
	public ResponseEntity<Category> CreateCategory(@RequestBody Category category) {
		System.out.println(category);
		Category savedCategory = categoryServiceImpl.createCategory(category);
		
		return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
	}
}
