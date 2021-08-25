package com.vendingmachine.springboot.demo.service;

import java.util.List;

import com.vendingmachine.springboot.demo.entity.BankStorage;

public interface BankStorageService {

	public List<BankStorage> findAll();
	
	public BankStorage findById(int id);
}
