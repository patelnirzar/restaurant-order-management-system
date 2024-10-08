package com.api.roms.services;

import java.util.List;

import com.api.roms.entities.Customer;
import com.api.roms.entities.Orders;

public interface OrderService {

	public Orders createOrder(Orders orders);
	public List<Orders> getOrders();
	public List<Orders> getOrdersByCustomer(Customer customer);
}
