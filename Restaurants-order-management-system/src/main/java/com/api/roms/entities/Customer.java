package com.api.roms.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(generator = "custom-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-id", strategy = "com.api.roms.helper.CustomCustomerIdGenerator")
	@Column(name = "cust_id")
	private String custId;
	private String name;
	private String contact;
	private String address;
	
	@OneToMany(mappedBy = "customer",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Orders> orders = new HashSet<Orders>();
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String custId, String name, String contact, String address, Set<Orders> orders) {
		super();
		this.custId = custId;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.orders = orders;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//@JsonIgnore
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", contact=" + contact + ", address=" + address
				+ ", orders=" + orders + "]";
	}


	
	
	
	

}
