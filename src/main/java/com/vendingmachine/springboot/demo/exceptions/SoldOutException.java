package com.vendingmachine.springboot.demo.exceptions;

public class SoldOutException extends Exception{

	public SoldOutException(String errorMessString) {
		super(errorMessString);
	}
}
