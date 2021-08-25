package com.vendingmachine.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	//fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	@Column(name="number_of_available_items")
	private int number_of_available_items;
	
	//constructors
	
	public Item() {
		
	}

	public Item(String name, int price, int number_of_available_items) { 
		this.name = name;
		this.price = price;
		this.number_of_available_items = number_of_available_items;
	}

	//getters & setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber_of_available_items() {
		return number_of_available_items;
	}

	public void setNumber_of_available_items(int number_of_available_items) {
		this.number_of_available_items = number_of_available_items;
	}

	//toString
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", number_of_available_items="
				+ number_of_available_items + "]";
	}
	
	
	
	
	

}
