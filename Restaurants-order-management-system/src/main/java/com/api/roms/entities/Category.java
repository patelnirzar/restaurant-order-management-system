package com.api.roms.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String catID, String catName) {
		super();
		this.catID = catID;
		this.catName = catName;
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

	@Override
	public String toString() {
		return "Category [catID=" + catID + ", catName=" + catName + "]";
	}
	
	
	

}
