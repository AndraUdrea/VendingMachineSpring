package com.vendingmachine.springboot.demo.dao;

import java.util.List;

import com.vendingmachine.springboot.demo.entity.BankStorage;
import com.vendingmachine.springboot.demo.entity.Item;

public interface BankStorageDao {

	public List<BankStorage> findAll();
	
	public BankStorage findById(int id);
	
	
}
