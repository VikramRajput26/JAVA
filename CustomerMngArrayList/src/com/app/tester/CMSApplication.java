package com.app.tester;


import static com.app.utils.CMSUtils.authenticateCustomer;

import static com.app.utils.CMSUtils.populateCustomer;

import com.app.CustomException.CMSException;
import com.app.utils.CMSUtils;
//import com.app.utils.CMSUtils;
import com.customer.Customer;

import static com.utils.CustomValidation.validateCustomerInputs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CMSApplication {

	public static void main(String[] args) {

		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			//			List<BankAccount> accounts = populateBankAccounts();
			//			List<Customer> customerList=new ArrayList<>();
			List<Customer> customerList1=populateCustomer();
			while(!exit) {
				System.out.println("options :\n1.Customer\n2.display all\n3.login\n4.change Password\n5.unsubscribe\n6.Sorting customers by Date of Birth\n 7.Sorting customers by Date of Birth and Service Plan\n8.Enter email to remove customer\n9.sort by dob and lastname\n 10.Sorting customers by Email\n");
				System.out.println("Choose");
				try {
					switch(sc.nextInt()) {
					case 1: 
						System.out.println("enter customer details :  firstName,lastName,  email, password,regAmount, dob ,plan");

						Customer customer= validateCustomerInputs(sc.next(), sc.next(), sc.next(), sc.next(),sc.nextDouble(),sc.next(), sc.next(),customerList1);
						customerList1.add(customer);
						System.out.println("customer registred");
						break;

					case 2:
						for(Customer c: customerList1 )
							System.out.println(c.toString());
						break;

					case 3:

						System.out.println("enter email and password ");
						customer = authenticateCustomer(sc.next(),sc.next(),customerList1);
						System.out.println("successfull login , your details "+customer);
						break;

					case 4:

						System.out.println("enter email n oldpassword  n newpassword ");
						customer = CMSUtils.authenticateCustomer(sc.next(),sc.next(),customerList1);
						customer.setPassword(sc.next());
						System.out.println("password changed !!");
						break;

					case 5:
						System.out.println("enter email to ");
						CMSUtils.deleteCustomerDetails(sc.next(), customerList1);
						System.out.println("deleted successfully !!");

						break;

					case 6:
						System.out.println("Sorting customers by Date of Birth:");
						customerList1.sort((c1, c2) -> c1.getDob().compareTo(c2.getDob()));
						for (Customer c : customerList1)
							System.out.println(c);
						break;

					case 7:
						System.out.println("Sorting customers by Date of Birth and Service Plan:");
						customerList1.sort((c1, c2) -> {
							int dobComparison = c1.getDob().compareTo(c2.getDob());
							if (dobComparison != 0) {
								return dobComparison;
							} else {
								return c1.getPlan().compareTo(c2.getPlan());
							}
						});
						for (Customer c : customerList1)
							System.out.println(c);
						break;
					case 8:
						System.out.println("Enter email to remove customer:");
						String emailToRemove = sc.next();
						try {
							System.out.println(CMSUtils.deleteCustomerDetails(emailToRemove, customerList1));
						} catch (CMSException e) {
							System.out.println(e.getMessage());
						}
						break;	
					case 9:
					    System.out.println("Sorting customers by Date of Birth and Last Name:");
					    customerList1.sort((c1, c2) -> {
					        int dobComparison = c1.getDob().compareTo(c2.getDob());
					        if (dobComparison != 0) {
					            return dobComparison;
					        } else {
					            return c1.getLastName().compareTo(c2.getLastName());
					        }
					    });
					    for (Customer c : customerList1)
					        System.out.println(c);
					    break;
					case 10:
					    System.out.println("Sorting customers by Email:");
					    customerList1.sort(Comparator.comparing(Customer::getEmail));
					    for (Customer c : customerList1)
					        System.out.println(c);
					    break;

					}
				}
				catch(Exception e) {
					sc.nextLine();
					System.out.println(e);
				}

			}
		}
	}



}
