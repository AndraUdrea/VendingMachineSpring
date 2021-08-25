package com.vendingmachine.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.springboot.demo.dao.BankStorageDao;
import com.vendingmachine.springboot.demo.dao.ItemDao;
import com.vendingmachine.springboot.demo.entity.BankStorage;
import com.vendingmachine.springboot.demo.entity.Item;
import com.vendingmachine.springboot.demo.service.BankStorageService;

@RestController
@RequestMapping("/api")
public class BankStorageController {

	private BankStorageService bankStorageService;
	
	@Autowired
	public BankStorageController(BankStorageService bankStorageService) {
		this.bankStorageService = bankStorageService;
	}
	
	@GetMapping("/bank")
	public List<BankStorage> findAll(){
		return bankStorageService.findAll();
	}
	
	@GetMapping("/bank/{id}")
	public BankStorage getBankStorage(@PathVariable ("id") int id) {
		BankStorage bankStorage = bankStorageService.findById(id);
		
		if(bankStorage == null) {
			throw new RuntimeException("Money id not found : " + id);
			
		}
		return bankStorage;
	}
}
