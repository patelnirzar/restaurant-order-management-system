package com.api.roms.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.roms.entities.Role;
import com.api.roms.entities.User;
import com.api.roms.config.AppConstants;
import com.api.roms.dto.UserDto;
import com.api.roms.repositories.RoleRepo;
import com.api.roms.repositories.UserRepo;
import com.api.roms.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDto createUser(User user) {
		Set<Role> LocalUserRoles = new HashSet<Role>();
		User localUser= user;
		user.setPassword(passwordEncoder.encode(localUser.getPassword()));
		
		System.out.println("Roles : " + user.getUserRoles());
		
		// roles 
		for(Role role: user.getUserRoles()) {
			Role repoRole = this.roleRepo.findById(role.getId()).get();
			LocalUserRoles.add(repoRole);
		}
		user.setUserRoles(LocalUserRoles);
			
		User savedUser = this.userRepo.save(user);
		return userToDto(savedUser);
	}
	
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	

}
