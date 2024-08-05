package com.api.roms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String Name;
	private String Email;
	private String Password;
	private String Contact;
	
	
	
	
	

}
