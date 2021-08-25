package com.vendingmachine.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.message.Message;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vendingmachine.springboot.demo.entity.Item;
import com.vendingmachine.springboot.demo.exceptions.SoldOutException;



@Repository
public class ItemDaoHibernateImpl implements ItemDao {
	
	
	private EntityManager entityManager;
	
	@Autowired
	public ItemDaoHibernateImpl( EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	
	public List<Item> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query <Item> theQuery= 
				currentSession.createQuery("from Item", Item.class);
				
		//execute query and get result list
		List<Item> items = theQuery.getResultList();
		
		//return the results
		
		return items;
	}

	@Override
	public Item findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Item item = currentSession.get(Item.class, id);
		
		
		return item;
		
	}

	@Override
	public void save(Item item) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(item);
		
		
	}

	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Item where id=:itemId");
		
		theQuery.setParameter("itemId", id);
		
		theQuery.executeUpdate();
	}



}
