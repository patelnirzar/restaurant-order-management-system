package com.api.roms.entities;

import org.hibernate.annotations.GenericGenerator;

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
	private String OrderItemId;
	private int qty;
	private int total;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(String orderItemId, int qty, int total, Item item, Order order) {
		super();
		OrderItemId = orderItemId;
		this.qty = qty;
		this.total = total;
		this.item = item;
		this.order = order;
	}

	public String getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		OrderItemId = orderItemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [OrderItemId=" + OrderItemId + ", qty=" + qty + ", total=" + total + ", item=" + item
				+ ", order=" + order + "]";
	}

	

	
	
	

}
