package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.roms.entities.User;

public interface UserRepo extends JpaRepository<User, String>{
	
	

}
