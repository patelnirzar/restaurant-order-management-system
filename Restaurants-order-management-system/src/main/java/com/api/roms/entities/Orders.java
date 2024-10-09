package com.api.roms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class Orders {
	
	@Id
	@GeneratedValue(generator = "custom-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-id", strategy = "com.api.roms.helper.CustomOrderIdGenerator")
	@Column(name = "order_id")
	private String orderID;
	private String orderDateTime;
	private String prepareDateTime;
	private String dispatchType;
	private String orderType;
	private int orderTotal;
	private int discount;
	private String paymentMode;
	private String orderStatus;
	private String customerNote;
	
	@OneToMany(mappedBy = "orders",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<OrderItem> orderItems= new HashSet<OrderItem>();
	
	@ManyToOne()
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String orderID, String orderDateTime, String prepareDateTime, String dispatchType, String orderType,
			int orderTotal, int discount, String paymentMode, String orderStatus, String customerNote,
			Set<OrderItem> orderItems, Customer customer) {
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

	public String getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getPrepareDateTime() {
		return prepareDateTime;
	}

	public void setPrepareDateTime(String prepareDateTime) {
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

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
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
		return "Orders [orderID=" + orderID + ", orderDateTime=" + orderDateTime + ", prepareDateTime=" + prepareDateTime
				+ ", dispatchType=" + dispatchType + ", orderType=" + orderType + ", orderTotal=" + orderTotal
				+ ", discount=" + discount + ", paymentMode=" + paymentMode + ", orderStatus=" + orderStatus
				+ ", customerNote=" + customerNote + ", orderItems=" + orderItems + ", customer=" + customer + "]";
	}

	
	

}
