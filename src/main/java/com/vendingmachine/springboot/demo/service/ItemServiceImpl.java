package com.vendingmachine.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vendingmachine.springboot.demo.dao.ItemDao;
import com.vendingmachine.springboot.demo.entity.Item;
import com.vendingmachine.springboot.demo.exceptions.SoldOutException;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemDao itemDao;
	
	public ItemServiceImpl(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	@Transactional
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
   @Transactional
	public Item findById(int id) {
		try {
			return itemDao.findById(id);
		} catch (SoldOutException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void save(Item item) {
		itemDao.save(item);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		itemDao.deleteById(id);

	}

}
