package com.api.roms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.roms.dto.UserDto;
import com.api.roms.entities.User;
import com.api.roms.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//UserHome
	@GetMapping("/home")
	public String UserHome() {
		return "User Home Page!!";
	}
	
	//POST Create User
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println(user);
		User createUser = userServiceImpl.createUser(user);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}

}
