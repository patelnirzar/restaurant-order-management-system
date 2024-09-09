package com.api.roms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.roms.entities.Item;
import com.api.roms.entities.Order;
import com.api.roms.repositories.ItemRepo;
import com.api.roms.repositories.OrderRepo;
import com.api.roms.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Order createOrder(Order order) {
		
		
		
		Order savedOrder = this.orderRepo.save(order);
		return savedOrder;
	}

}
