package com.api.roms.dto;

import java.util.HashSet;
import java.util.Set;

import com.api.roms.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
	
	private String userId;
	private String name;
	private String email;
	private String password;
	private String contact;
	private Set<Role> userRoles = new HashSet<Role>();
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserDto(String userId, String name, String email, String password, String contact, Set<Role> userRoles) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.userRoles = userRoles;
	}


	

	public Set<Role> getUserRoles() {
		return userRoles;
	}



	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
