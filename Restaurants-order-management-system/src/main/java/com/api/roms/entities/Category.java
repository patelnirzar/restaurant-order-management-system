package com.api.roms.entities;

import java.util.ArrayList;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(generator = "custom-id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "custom-id", strategy = "com.api.roms.helper.CustomCatIdGenerator")
	@Column(name = "cat_id")
	private String catID;
	private String catName;
	
	@OneToMany(mappedBy = "category",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Item> items= new ArrayList<Item>();
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String catID, String catName, List<Item> items) {
		super();
		this.catID = catID;
		this.catName = catName;
		this.items = items;
	}

	public String getCatID() {
		return catID;
	}

	public void setCatID(String catID) {
		this.catID = catID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Category [catID=" + catID + ", catName=" + catName + ", items=" + items + "]";
	}

	
	
	

}
