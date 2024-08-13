package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {

}
