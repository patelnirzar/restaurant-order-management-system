package com.api.roms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Customer;
import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{
	
	public Customer findByContact(String contact);
	
	public boolean existsByContact(String contact);
	

}
