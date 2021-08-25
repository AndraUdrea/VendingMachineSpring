package com.vendingmachine.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_storage")
public class BankStorage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="money_count")
	private int money_count;
	
	public BankStorage() {
		
	}

	public BankStorage(String name, int money_count) {
		this.name = name;
		this.money_count = money_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney_count() {
		return money_count;
	}

	public void setMoney_count(int money_count) {
		this.money_count = money_count;
	}

	@Override
	public String toString() {
		return "BankStorage [id=" + id + ", name=" + name + ", money_count=" + money_count + "]";
	}
	
	

}
