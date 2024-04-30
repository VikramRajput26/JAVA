package com.cust.management;

import java.util.ArrayList;
import java.util.List;
public class CustomManager {
	 private List<Customer> customers;

	    public void CustomerManager() {
	        customers = new ArrayList<>();
	    }

	    public void register(Customer customer) throws CustomException {
	        // Check for duplicate email
	        for (Customer c : customers) {
	            if (c.getEmail().equals(customer.getEmail())) {
	                throw new CustomException("Email already exists.");
	            }
	        }
	        // Add customer
	        customers.add(customer);
	    }
}
