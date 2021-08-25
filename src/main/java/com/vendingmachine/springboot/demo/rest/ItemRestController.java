package com.vendingmachine.springboot.demo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.springboot.demo.dao.ItemDao;
import com.vendingmachine.springboot.demo.entity.Item;
import com.vendingmachine.springboot.demo.exceptions.SoldOutException;
import com.vendingmachine.springboot.demo.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	private ItemService itemService;
	
	@Autowired
	public ItemRestController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	@GetMapping("/items/{id}")
    public String getItem(@PathVariable ("id") int id) throws SoldOutException {
		
		Item item = itemService.findById(id);
		
		
		if (item == null) {
			throw new RuntimeException("Item id not found : " + id);
		}
		
		try {
		if(item.getNumber_of_available_items() != 0) 
			return "You selected " + item.getName() + " (price:  "+item.getPrice() +" )";
		else if(item.getNumber_of_available_items() == 0 ){
			throw new SoldOutException("sold out");
		}
		
		}
		
		catch (SoldOutException e) {
			e.printStackTrace();
			
		}
		return item.getName() + " is sold out :(";

		
	}
	

	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		
		item.setId(0);
		
		itemService.save(item);
		
		return item;
	}
	
	@PutMapping Item updateItem(@RequestBody Item item) {
		itemService.save(item);
		return item;
	}
	
	@DeleteMapping("/items/{id}")
	public String deleteItem(@PathVariable ("id") int id) {
		Item item = itemService.findById(id);
		
		if(item == null) {
			throw new RuntimeException("Item id not found - " + id);
			
		}
		itemService.deleteById(id);
		
		return "Deleted item id - " + id;
	}
	
}
