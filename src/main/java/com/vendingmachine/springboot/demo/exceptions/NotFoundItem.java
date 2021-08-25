package com.vendingmachine.springboot.demo.exceptions;

public class NotFoundItem extends Exception{
	
	public NotFoundItem(String errorMessage) {
		super(errorMessage);
	}

}
