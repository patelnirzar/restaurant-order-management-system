package com.api.roms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.roms.entities.Category;
import com.api.roms.entities.Item;
import com.api.roms.repositories.CategoryRepo;
import com.api.roms.repositories.ItemRepo;
import com.api.roms.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	//Add item
	@Override
	public Item AddItem(Item item) {
		
		Category repoCategory = this.categoryRepo.findById(item.getCategory().getCatID()).get();
		item.setCategory(repoCategory);
		
		Item savedItem = this.itemRepo.save(item);
		return savedItem;
	}

	

}
