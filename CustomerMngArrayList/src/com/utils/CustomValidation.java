package com.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.CustomException.CMSException;
import com.customer.Customer;
import com.customer.ServicePlan;

public class CustomValidation {

	public static void checkForDupCustomer(String email, List<Customer>customerList) throws CMSException {
		Customer newCust=new Customer(email);
		if(customerList.contains(newCust))
			throw new CMSException("Dup Email");
	}

	public static ServicePlan parseAndValidatePlanAndCharges(String plan,double regAmount ) throws CMSException{
		ServicePlan servicePlan=ServicePlan.valueOf(plan.toUpperCase());
		if(servicePlan.getPlanCost()==regAmount) {
			return servicePlan;
			
		}
		throw new CMSException("Reg amount doesn't match with the chosed plan ");
	}
	
	
	
	//add validate all input method return customer 
   public static Customer  validateCustomerInputs(String firstName, String lastName, String email, String password, double regAmount,
			String dob, String plan,List<Customer> customers) throws CMSException {
		checkForDupCustomer(email, customers);
		ServicePlan servicePlan =parseAndValidatePlanAndCharges(plan, regAmount);
		LocalDate birthdate=LocalDate.parse(dob);
		return new Customer(firstName, lastName, email, password, regAmount, birthdate, servicePlan);
		
	}
	
	
}
