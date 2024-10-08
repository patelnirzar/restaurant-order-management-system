package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	
}