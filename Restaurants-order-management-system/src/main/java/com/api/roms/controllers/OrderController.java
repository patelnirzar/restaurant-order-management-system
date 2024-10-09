package com.api.roms.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.coyote.http11.Http11InputBuffer;
import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.roms.entities.Customer;
import com.api.roms.entities.Item;
import com.api.roms.entities.Orders;
import com.api.roms.helper.ApiResponse;
import com.api.roms.entities.OrderItem;
import com.api.roms.repositories.CustomerRepo;
import com.api.roms.repositories.OrderItemRepo;
import com.api.roms.repositories.OrderRepo;
import com.api.roms.services.impl.OrderServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/user")
public class OrderController {

	@Autowired
	private OrderItemRepo orderItemRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	// create new order
	@PostMapping("/order/create")
	public ResponseEntity<Orders> OrderCreate(@RequestBody Orders orders) {
		System.out.println("from controller " + orders);

		Orders savedOrder = this.orderServiceImpl.createOrder(orders);

		return new ResponseEntity<Orders>(savedOrder, HttpStatus.CREATED);
	}

	// get all orders
	@GetMapping("/orders/all")
	public ResponseEntity<List<Orders>> getAllOrders(Principal principal) {
		
		List<Orders> allOrdersList = this.orderServiceImpl.getOrders();
		
		allOrdersList.removeIf(order -> order.getOrderStatus().equals("Delivered"));  // remove order if order is Delivered

		return ResponseEntity.ok(allOrdersList);
	}

	// get all orders by Customer
	@GetMapping("/orders/{custid}")
	public ResponseEntity<List<Orders>> getAllOrdersByCustomer(@PathVariable String custid) {
		
		Customer customer = customerRepo.getById(custid);
			
		List<Orders> allOrdersList = this.orderServiceImpl.getOrdersByCustomer(customer);

		return ResponseEntity.ok(allOrdersList);
	}
	
	//update status of order
	@GetMapping("/order/status/{orderID}/{status}")
	public ResponseEntity<Orders> changeOrderStatus(@PathVariable String orderID,
			@PathVariable String status) {
		
		Orders orders = orderRepo.getById(orderID);
		orders.setOrderStatus(status);
		Orders updatedOrders = orderRepo.save(orders);
		
		return ResponseEntity.ok(updatedOrders);
	}
	

}
