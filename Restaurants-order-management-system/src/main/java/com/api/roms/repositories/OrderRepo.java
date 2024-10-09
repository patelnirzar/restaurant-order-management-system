package com.api.roms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.roms.entities.Customer;
import com.api.roms.entities.Orders;


public interface OrderRepo extends JpaRepository<Orders, String> {
	
	List<Orders> findByCustomer(Customer customer);
	
}
