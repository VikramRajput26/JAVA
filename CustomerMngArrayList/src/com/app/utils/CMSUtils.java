package com.app.utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.CustomException.CMSException;


import com.customer.Customer;
import com.customer.ServicePlan;
public class CMSUtils {

	public static Customer authenticateCustomer(String email,String password,List<Customer>list) throws CMSException {

		Customer newCustomer=new Customer(email);
		int index=list.indexOf(newCustomer);
		if(index== -1) 
			throw new CMSException("Invalid email , login failed ");

		Customer customer = list.get(index);
		if(customer.getPassword().equals(password)) 
			return customer;
		throw new CMSException("Invalid email ,login failed ");

	}

	public static String deleteCustomerDetails(String email, List<Customer>customerList) throws CMSException {
		int index= customerList.indexOf(new Customer(email));
		if(index== -1)
			throw new CMSException("cant unsubscribe invalid email");
		return"removed details of "+customerList.remove(index).getFirstName();
	}

	public static List<Customer> populateCustomer(){
		Customer a1 = new Customer("Vikram", "Rajput", "vikram@gmail.com","1234",1000,LocalDate.parse("2000-01-01"),ServicePlan.SILVER );
		Customer a2 = new Customer("Virat", "kohli", "virat1234@gmail.com","virat1234",2000,LocalDate.parse("1991-01-01"),ServicePlan.GOLD );
		Customer a3 = new Customer("Glenn", "maxwell", "glenn@gmail.com","glenn1234",2000,LocalDate.parse("1991-01-01"),ServicePlan.GOLD );
		Customer a4 = new Customer("dinesh", "kartik", "dk@gmail.com","dk1234",10000,LocalDate.parse("1999-01-01"),ServicePlan.PLATINUM );
		Customer a5 = new Customer("ab", "deviliers", "ab@gmail.com","ab1234",5000,LocalDate.parse("1980-01-01"),ServicePlan.DIAMOND );
		Customer a6 = new Customer("dhoni", "mahi", "dhoni@gmail.com","mahi1234",5000,LocalDate.parse("1971-01-01"),ServicePlan.DIAMOND );
		Customer a7 = new Customer("rohit", "sharma", "rohit@gmail.com","sharma1234",10000,LocalDate.parse("1988-01-01"),ServicePlan.PLATINUM );
		Customer a8 = new Customer("shivam", "dube", "sh@gmail.com","sh1234",2000,LocalDate.parse("1996-01-01"),ServicePlan.GOLD );
		Customer a9 = new Customer("ravindra", "jadeja", "ravindra@gmail.com","jadeja1234",5000,LocalDate.parse("1999-02-02"),ServicePlan.DIAMOND );
		Customer a10 = new Customer("kl", "Rahul", "kl@gmail.com","kl1234",1000,LocalDate.parse("1989-01-01"),ServicePlan.SILVER );
		Customer a11 = new Customer("Vicky", "Rajput", "vicky@gmail.com","vicky1234",1000,LocalDate.parse("1998-01-01"),ServicePlan.SILVER );
		Customer[] cust = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11};
		List<Customer> list = new ArrayList<Customer>();// up casting

		for (Customer c : cust) {
			list.add(c);
		}

		return list;
	} 


}
