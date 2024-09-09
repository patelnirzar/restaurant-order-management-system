package com.api.roms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(generator = "custom-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-id", strategy = "com.api.roms.helper.CustomOrderIdGenerator")
	@Column(name = "order_id")
	private String orderID;
	private Date orderDateTime;
	private Date prepareDateTime;
	private String dispatchType;
	private String orderType;
	private int orderTotal;
	private int discount;
	private String paymentMode;
	private String orderStatus;
	private String customerNote;
	
	@OneToMany(mappedBy = "order",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderItem> orderItems= new ArrayList<OrderItem>();
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderID, Date orderDateTime, Date prepareDateTime, String dispatchType, String orderType,
			int orderTotal, int discount, String paymentMode, String orderStatus, String customerNote,
			List<OrderItem> orderItems, Customer customer) {
		super();
		this.orderID = orderID;
		this.orderDateTime = orderDateTime;
		this.prepareDateTime = prepareDateTime;
		this.dispatchType = dispatchType;
		this.orderType = orderType;
		this.orderTotal = orderTotal;
		this.discount = discount;
		this.paymentMode = paymentMode;
		this.orderStatus = orderStatus;
		this.customerNote = customerNote;
		this.orderItems = orderItems;
		this.customer = customer;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Date getPrepareDateTime() {
		return prepareDateTime;
	}

	public void setPrepareDateTime(Date prepareDateTime) {
		this.prepareDateTime = prepareDateTime;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDateTime=" + orderDateTime + ", prepareDateTime=" + prepareDateTime
				+ ", dispatchType=" + dispatchType + ", orderType=" + orderType + ", orderTotal=" + orderTotal
				+ ", discount=" + discount + ", paymentMode=" + paymentMode + ", orderStatus=" + orderStatus
				+ ", customerNote=" + customerNote + ", orderItems=" + orderItems + ", customer=" + customer + "]";
	}
	
	
	

}
