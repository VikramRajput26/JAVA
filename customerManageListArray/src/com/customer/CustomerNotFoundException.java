package com.customer;

public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException(String message) {
        super(message);
    }
}
