package com.api.roms.services;

import com.api.roms.dto.UserDto;
import com.api.roms.entities.User;

public interface UserService {
	
	public UserDto createUser(User user);

}
