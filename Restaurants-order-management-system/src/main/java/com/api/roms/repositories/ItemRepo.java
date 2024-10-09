package com.api.roms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Item;
import com.api.roms.entities.Category;


@Repository
public interface ItemRepo extends JpaRepository<Item, String> {
	
	public List<Item> findByCategory(Category category);

}
