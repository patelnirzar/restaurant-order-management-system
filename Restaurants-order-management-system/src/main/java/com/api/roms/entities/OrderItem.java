package com.api.roms.entities;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(generator = "custom-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-id", strategy = "com.api.roms.helper.CustomOrderItemIdGenerator")
	@Column(name = "order_item_id")
	private String orderItemId;
	private int qty;
	private double total;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Orders orders;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(String orderItemId, int qty, double total, Item item, Orders orders) {
		super();
		this.orderItemId = orderItemId;
		this.qty = qty;
		this.total = total;
		this.item = item;
		this.orders = orders;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	//added @JsonIgnore here to stop endless loop while fetching orderItem or Order obj
	@JsonIgnore
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", qty=" + qty + ", total=" + total + ", item=" + item
				+ ", orders=" + orders + "]";
	}

	
	
	
	

	
	
	

}
