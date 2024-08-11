package com.api.roms.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.api.roms.entities.User;
import com.api.roms.exception.ResourceNotFoundException;
import com.api.roms.repositories.UserRepo;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 
		return userRepo.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", " UserId : " + username, 0));
	}
	
}
