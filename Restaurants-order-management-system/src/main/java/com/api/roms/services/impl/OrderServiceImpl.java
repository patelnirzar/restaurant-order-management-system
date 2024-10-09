package com.api.roms.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

	// create new order
	@Override
	public Orders createOrder(Orders orders) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		orders.setOrderDateTime(formatter.format(date));
		
		OffsetDateTime odt = OffsetDateTime.parse(orders.getPrepareDateTime()+"z");
		orders.setPrepareDateTime(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(odt.toLocalDateTime()));
		
		orders.setOrderStatus("Created");

		Set<OrderItem> localOrderItems = new HashSet<OrderItem>();
		Set<OrderItem> localOrderItems1 = new HashSet<OrderItem>();

		// setting items in orderItem obj
		for (OrderItem orderItem : orders.getOrderItems()) {

			// feteching item from orderitem
			Item fatechedItem = itemRepo.findById(orderItem.getItem().getItemId()).get();
			orderItem.setItem(fatechedItem);
			localOrderItems.add(orderItem);
		}

		// set updated full item obj
		orders.setOrderItems(localOrderItems);

		// check if customer is already exist or not
		if (customerRepo.existsByContact(orders.getCustomer().getContact())) {
			Customer contact = customerRepo.findByContact(orders.getCustomer().getContact());
			orders.setCustomer(contact);
		}
		else {
			Customer saveCustomer = customerRepo.save(orders.getCustomer());
			orders.setCustomer(saveCustomer);
		}

		// create order
		Orders savedOrder = this.orderRepo.save(orders);

		// fetch orderItem obj from savedOrder and set saveOrder into orderItem obj
		for (OrderItem orderItem : savedOrder.getOrderItems()) {
			System.out.println("orderItem : " + orderItem.getOrderItemId());

			orderItem.setOrders(savedOrder); // set saveOrder to orderItem
			localOrderItems1.add(orderItem); // create local list to store final updated orderItem with saveOrder

		}

		// set new updated orderItem List
		savedOrder.setOrderItems(localOrderItems1);

		// Update order
		Orders savedOrder1 = this.orderRepo.save(savedOrder);

		return savedOrder1;
	}

	// get all orders
	@Override
	public List<Orders> getOrders() {

		List<Orders> allOrdersList = this.orderRepo.findAll();

		return allOrdersList;
	}

	// get all orders by Customer
	@Override
	public List<Orders> getOrdersByCustomer(Customer customer) {
		System.out.println(customer.getName());
		
		List<Orders> allOrdersList = this.orderRepo.findByCustomer(customer);
		
		return allOrdersList;
	}

	

	



}
