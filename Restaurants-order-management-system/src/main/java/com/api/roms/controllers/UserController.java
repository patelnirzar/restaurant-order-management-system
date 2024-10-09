package com.api.roms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.roms.entities.Category;
import com.api.roms.entities.Item;
import com.api.roms.repositories.CategoryRepo;
import com.api.roms.repositories.ItemRepo;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ItemRepo itemRepo;

	// UserHome
	@GetMapping("/home")
	public String UserHome() {
		return "User Home Page!!";
	}

	// get all categories
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategory() {

		List<Category> allCategories = this.categoryRepo.findAll();

		return ResponseEntity.ok(allCategories);

	}

	// get all items
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getAllItems() {

		List<Item> allItems = this.itemRepo.findAll();

		return ResponseEntity.ok(allItems);

	}
	
	//get all items by category wise
	@GetMapping("/items/{catID}")
	public ResponseEntity<List<Item>> getAllItemsbyCatId(@PathVariable String catID) {
		
		Category category = this.categoryRepo.findById(catID).get();

		List<Item> allItems = this.itemRepo.findByCategory(category);

		return ResponseEntity.ok(allItems);

	} 

}
