package com.vendingmachine.springboot.demo.dao;

import java.util.List;

import com.vendingmachine.springboot.demo.entity.Item;
import com.vendingmachine.springboot.demo.exceptions.SoldOutException;

public interface ItemDao {

	public List<Item> findAll();
	
	public Item findById(int id) throws SoldOutException;
	
	public void save(Item item);
	
	public void deleteById(int id);
	

	
}
