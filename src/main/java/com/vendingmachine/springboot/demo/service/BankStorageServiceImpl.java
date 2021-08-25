package com.vendingmachine.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendingmachine.springboot.demo.dao.BankStorageDao;
import com.vendingmachine.springboot.demo.entity.BankStorage;
import com.vendingmachine.springboot.demo.entity.Item;

@Service
public class BankStorageServiceImpl implements BankStorageService {

	private BankStorageDao bankStorageDao;
	
	public BankStorageServiceImpl(BankStorageDao bankStorageDao) {
		this.bankStorageDao = bankStorageDao;
	}
	
	@Override
	@Transactional
	public List<BankStorage> findAll() {
		return bankStorageDao.findAll();
	}

	@Override
	@Transactional
	public BankStorage findById(int id) {
			return bankStorageDao.findById(id);
		
		
	}

}
