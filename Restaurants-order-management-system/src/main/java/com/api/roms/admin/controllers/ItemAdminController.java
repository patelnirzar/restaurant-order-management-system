package com.api.roms.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.roms.entities.Category;
import com.api.roms.entities.Item;
import com.api.roms.services.impl.ItemServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
public class ItemAdminController {
	
	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	//add items
	@PostMapping("/item/add")
	public ResponseEntity<Item> CreateCategory(@RequestBody Item item) {
		System.out.println(item);
		
		Item savedItem = this.itemServiceImpl.AddItem(item);
		
		return new ResponseEntity<>(savedItem,HttpStatus.CREATED);
	}

}
