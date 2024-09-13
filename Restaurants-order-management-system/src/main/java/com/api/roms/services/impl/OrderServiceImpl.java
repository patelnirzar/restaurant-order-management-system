package com.api.roms.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.roms.entities.Customer;
import com.api.roms.entities.Item;
import com.api.roms.entities.Orders;
import com.api.roms.entities.OrderItem;
import com.api.roms.repositories.CustomerRepo;
import com.api.roms.repositories.ItemRepo;
import com.api.roms.repositories.OrderItemRepo;
import com.api.roms.repositories.OrderRepo;
import com.api.roms.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ItemRepo itemRepo;

	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	//create new order
	@Override
	public Orders createOrder(Orders orders) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
		orders.setOrderDateTime(formatter.format(date));
		orders.setPrepareDateTime(orders.getPrepareDateTime());
		orders.setOrderStatus("Created");
		
		
		Set<OrderItem> localOrderItems= new HashSet<OrderItem>();
		
		//setting items in orderItem obj
		for(OrderItem orderItem: orders.getOrderItems()) {
			
			//feteching item from orderitem 
			Item fatechedItem = itemRepo.findById(orderItem.getItem().getItemId()).get();
			orderItem.setItem(fatechedItem);
			localOrderItems.add(orderItem);
		}
		
		//set updated full item obj
		orders.setOrderItems(localOrderItems);
		
		//check if customer is already exist or not
		if(customerRepo.existsByContact(orders.getCustomer().getContact())) {
			Customer contact = customerRepo.findByContact(orders.getCustomer().getContact());
			orders.setCustomer(contact);
		}
		
		//create order
		Orders savedOrder = this.orderRepo.save(orders);
		
		//fetch orderItem obj and set orderId into orderItem obj
		for(OrderItem orderItem: savedOrder.getOrderItems()) {
			
			OrderItem fatchedOrderItem = orderItemRepo.findById(orderItem.getOrderItemId()).get();
			fatchedOrderItem.setOrders(savedOrder);
			orderItemRepo.save(fatchedOrderItem);
		}

		return savedOrder;
	}

	//get all orders 
	@Override
	public List<Orders> getOrders() {
		
		List<Orders> allOrdersList = this.orderRepo.findAll();
		
		return allOrdersList;
	}
	
	

}
