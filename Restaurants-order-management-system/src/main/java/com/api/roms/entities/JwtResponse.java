package com.api.roms.entities;

import com.api.roms.dto.UserDto;

public class JwtResponse {
	
	private String jwtToken;
	private UserDto userDto;
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", userDto=" + userDto + "]";
	}
	public JwtResponse(String jwtToken, UserDto userDto) {
		super();
		this.jwtToken = jwtToken;
		this.userDto = userDto;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
