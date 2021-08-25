package com.vendingmachine.springboot.demo.service;

import java.util.List;

import com.vendingmachine.springboot.demo.entity.Item;

public interface ItemService {

	public List<Item> findAll();
	
	public Item findById(int id);
	
	public void save(Item item);
	
	public void deleteById(int id);
	
	
}
