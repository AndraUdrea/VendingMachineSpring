package com.vendingmachine.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vendingmachine.springboot.demo.entity.BankStorage;
import com.vendingmachine.springboot.demo.entity.Item;

@Repository
public class BankStorageHibernateImpl implements BankStorageDao {

private EntityManager entityManager;
	
	@Autowired
	public BankStorageHibernateImpl( EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public List<BankStorage> findAll() {
		//get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				//create a query
				Query <BankStorage> theQuery= 
						currentSession.createQuery("from BankStorage", BankStorage.class);
						
				//execute query and get result list
				List<BankStorage> bankStorage = theQuery.getResultList();
				
				//return the results
				
				return bankStorage;
	}


	@Override
	public BankStorage findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		BankStorage bankStorage = currentSession.get(BankStorage.class, id);
		
		return bankStorage;
	}



}
