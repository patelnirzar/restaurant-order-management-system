package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, String> {

}
